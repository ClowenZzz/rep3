package com.turing.sp5.controller;

import com.turing.sp5.entity.User;
import com.turing.sp5.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ResponseBody
    public String login(User user, HttpSession session){
                user = loginService.login(user);
                System.out.print(user);
                if(user == null){
                    log.info("登录失败");
                    return "error";
                }else{
                    //保存session
                    log.info("登录成功");
                    session.setAttribute("user", user);
                    return "true";
        }
    }
}
