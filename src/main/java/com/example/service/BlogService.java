package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Blog;
import com.example.vo.BlogQuery;
import com.example.vo.BlogVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LSD
 * @since 2021-07-23
 */
public interface BlogService{
    //根据id查询一篇博客
    Blog getBlog(Long id);

    //查询所有blog
    IPage<BlogVO> listBlog(Page<BlogVO> page);

    //根据条件查询一组blog
    IPage<BlogVO> listBlogSearch(Page<BlogVO> page, BlogQuery blogQuery);

    //新增一篇博客
    int saveBlog(Blog blog);

    //修改Blog
    int updateBlog(Blog blog);

    //删除Blog
    int deleteBlog(Long id);
}
