package com.finn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AjaxController {

    @RequestMapping("test/ajax")
    public void testAjax(Integer id, HttpServletResponse response) throws IOException {
        System.out.println("id:" + id);
        response.getWriter().write("hello, axios"); //涉及到流
    }
}
