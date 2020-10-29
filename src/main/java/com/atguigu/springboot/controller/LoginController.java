package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class LoginController {
//    @GetMapping
//    @PutMapping
//    @DeleteMapping
//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) &&"123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } else {
            map.put("msg","Username or Password is incorrect!");
            return "login";
        }


    }
}
