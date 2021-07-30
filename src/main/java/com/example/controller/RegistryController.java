package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : LSD
 * @version : 1.0
 * @ClassName : RegistryController
 * @Description : TODO
 * @date : 2021/7/25 22:08
 * 注册
 **/
@Controller
@RequestMapping("registry")
public class RegistryController {
    @Autowired
    private UserService service;

    @GetMapping("/insertUser")
    public String inAddUser(){
        return "insertUser";
    }

    @PostMapping(value = "/addUser")
    public String addUser(User user){
        service.insert(user);
        return "login";
    }
}
