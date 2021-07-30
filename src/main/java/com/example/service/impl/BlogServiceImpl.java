package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Blog;
import com.example.entity.BlogTags;
import com.example.entity.Comment;
import com.example.mapper.BlogMapper;
import com.example.mapper.BlogTagsMapper;
import com.example.mapper.CommentMapper;
import com.example.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.utils.TagsUtils;
import com.example.vo.BlogQuery;
import com.example.vo.BlogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LSD
 * @since 2021-07-23
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private BlogTagsMapper blogAndTagsMapper;
    @Autowired
    private CommentMapper commentMapper;

    private List<Long> tagsId;

    @Override
    public Blog getBlog(Long id) {
        return blogMapper.selectById(id);
    }

    @Override
    public IPage<BlogVO> listBlog(Page<BlogVO> page) {
        return blogMapper.listBlog(page);
    }

    @Override
    public IPage<BlogVO> listBlogSearch(Page<BlogVO> page, BlogQuery blogQuery) {
        return blogMapper.listBlogSearch(page, blogQuery);
    }

    @Transactional
    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(LocalDateTime.now());
        blog.setUpdateTime(LocalDateTime.now());
        blog.setViews(0);
        int res = blogMapper.insert(blog);
        //为中间表插入数据
        tagsId = TagsUtils.convertToList(blog.getTagIds());
        for (Long tagId : tagsId) {
            BlogTags bat = new BlogTags();
            bat.setBlogId(blog.getId());
            bat.setTagId(tagId);
            blogAndTagsMapper.insert(bat);
        }
        return res;
    }

    @Transactional
    @Override
    public int updateBlog(Blog blog) {
        blog.setUpdateTime(LocalDateTime.now());
        blogAndTagsMapper.delete(new QueryWrapper<BlogTags>().eq("blog_id",blog.getId()));

        tagsId = TagsUtils.convertToList(blog.getTagIds());
        for (Long tagId : tagsId) {
            BlogTags bat = new BlogTags();
            bat.setBlogId(blog.getId());
            bat.setTagId(tagId);
            blogAndTagsMapper.insert(bat);
        }
        return blogMapper.updateById(blog);
    }

    @Transactional
    @Override
    public int deleteBlog(Long id) {
        //删除该博客时，将所有中间表关于该博客的信息都删除
        blogAndTagsMapper.delete(new QueryWrapper<BlogTags>().eq("blog_id",id));
        //将记录也删除
        commentMapper.delete(new QueryWrapper<Comment>().eq("blog_id",id));
        return blogMapper.deleteById(id);
    }
}