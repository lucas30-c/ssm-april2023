package com.finn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    在基础路径下（上下文），加上/test/hello 就是要访问的地址
    相当有用！！
 */

@Controller
@RequestMapping("/test") //设置请求映射的基础信息
public class TestRequestMappingController {

    @RequestMapping("/hello") //设置请求映射的具体信息
    public String hello() {
        return "success";
    }
}
