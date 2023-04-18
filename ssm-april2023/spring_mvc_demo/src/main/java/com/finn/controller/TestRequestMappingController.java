package com.finn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
1.
    在基础路径下（上下文），加上/test/hello 就是要访问的地址
    相当有用！！
2.
    @RequestMapping的value属性
    作用：通过请求的路径匹配请求。
    value属性是数组类型，即当前浏览器所发送的请求路径匹配value属性中的任何一个值。
    则当前请求就会被注解所标识的方法处理。
 */

@Controller
@RequestMapping("/test") //设置请求映射的基础信息
public class TestRequestMappingController {

    //只有表单提交的请求方式是POST，剩下全部是GET
    @RequestMapping(value = {"/hello", "/bennett"},
                    method = RequestMethod.GET
    ) //设置请求映射的具体信息
    public String hello() {
        return "success";
    }
}
