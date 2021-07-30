package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Type;
import com.example.mapper.TypeMapper;
import com.example.service.TypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LSD
 * @since 2021-07-23
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Transactional
    @Override
    public int saveType(Type type) {
        return typeMapper.insert(type);
    }

    @Override
    public Type getType(Long id) {
        return typeMapper.selectById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.selectOne(new QueryWrapper<Type>().eq("name", name));
    }

    @Override
    public IPage<Type> listType(Page<Type> page) {
        return typeMapper.selectPage(page, null);
    }

    @Override
    public List<Type> listType() {
        return typeMapper.selectList(null);
    }

    @Override
    public List<Type> listBlogType() {
        return null;
    }

    @Transactional
    @Override
    public int updateType(Type type) {
        return typeMapper.updateById(type);
    }

    @Transactional
    @Override
    public int deleteType(Long id) {
        return typeMapper.deleteById(id);
    }
}
