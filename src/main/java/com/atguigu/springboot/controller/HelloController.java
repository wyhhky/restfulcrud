package com.atguigu.springboot.controller;

import com.atguigu.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController<map> {

    @RequestMapping({"/","/index.html"})
    public String index(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if (user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World Controller!";
    }

    //MAP后面定义map不需要逗号;另外注意下面的函数名以小写开始
    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        map.put("hellov","<h1>HelloVaule</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        //本API不直接返回到HTML response body, 但是会调用templates/success.html返回
        return "success";
    }

}
