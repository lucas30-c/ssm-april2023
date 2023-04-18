package com.finn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制层组件
@Controller
public class HelloController {

    //slash代表绝对路径，此处是服务器解析的绝对路径
    @RequestMapping("/")
    public String portal() {
        //将逻辑视图返回（去掉物理视图的前后缀）
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "success";
    }
}


//pull
