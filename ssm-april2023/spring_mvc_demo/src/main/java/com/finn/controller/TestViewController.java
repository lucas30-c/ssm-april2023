package com.finn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestViewController {

    //（会被ThymeLeaf渲染）
    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView() {
        return "success";
    }

    //这个用的不多（不会被ThymeLeaf渲染）
    //这个是转发，地址栏不变
    @RequestMapping("/test/view/forward")
    public String testInternalResourceView() {
        return "forward:/test/model";
    }

    //这个是重定向，地址栏变化
    @RequestMapping("/test/view/redirect")
    public String testRedirectView() {
        return "redirect:/test/model";
    }
}
