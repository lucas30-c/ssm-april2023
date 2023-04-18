package com.finn.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class PortalController {

    @RequestMapping("/")
    public String portal() {
        return "index";
    }
}
