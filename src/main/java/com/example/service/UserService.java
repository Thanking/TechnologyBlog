package com.example.service;

import com.example.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *
 * </p>
 *
 * @author LSD
 * @since 2021-07-23
 */
public interface UserService{
    //验证登录信息
    User checkUser(String username, String password);
    //增加管理人员
    int insert(User user);

}
