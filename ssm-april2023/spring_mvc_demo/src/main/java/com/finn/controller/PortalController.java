package com.finn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //必须加注解，否则404
public class PortalController {

//    @RequestMapping("/") //首页
//    public String portal() {
//        return "index";
//    }

    @RequestMapping("/hello")
    public String success() {
        return "success";
    }
}
