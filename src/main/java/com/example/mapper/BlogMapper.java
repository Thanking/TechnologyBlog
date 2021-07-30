package com.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.vo.BlogQuery;
import com.example.vo.BlogVO;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LSD
 * @since 2021-07-23
 */
@Repository
public interface BlogMapper extends BaseMapper<Blog> {
    //分页查询所有
    IPage<BlogVO> listBlog(Page<BlogVO> page);

    //根据BlogVO进行条件查询
    IPage<BlogVO> listBlogSearch(Page<BlogVO> page, BlogQuery blogQuery);
}
