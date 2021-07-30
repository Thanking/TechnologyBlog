package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author : LSD
 * @version : 1.0
 * @ClassName : LoginController
 * @Description : TODO
 * @date : 2021/7/23 17:13
 **/
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    //跳转到登录页面
    @GetMapping({"/","/admin"})
    public String loginPage(){
        return "login";
    }


    //登录
    @PostMapping("/admin/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        RedirectAttributes attributes,
                        Model model
                        ){
        User user = userService.checkUser(username,password);
        System.out.println(user);

        if(user != null){

            user.setPassword(null);
            session.setAttribute("user", user);
            model.addAttribute("username",username);
            return "main";

        } else {
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }

    }

    //注销
    @GetMapping("/admin/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}


