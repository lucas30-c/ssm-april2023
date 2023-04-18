package com.finn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

3.
    @RequestMapping注解的Mapping属性。
    作用：通过请求方式匹配请求。
    如果浏览器的请求方式不匹配，则报405.
    method属性是RequestMethod类型的数组。
    匹配数组中任何一种请求方式即可

4.
    SpringMVC支持ant风格的路径
    在@RequestMapping注解的vvalue属性中设置一些特殊字符
    ?: 任意的单个字符（不包括?）
    *: 表示任意个数的任意字符（不包括?和/）
    **: 任意层数的任意目录，注意使用方式只能**写在双斜线中，前后不能有任何其他字符。

5. @RequestMapping使用路径中的占位符
    传统：/deleteUser?id=1
    restful：/user/delete/1
    需要在@RequestMapping的value属性中所设置的路径中，用{xxx}表示路径中的数据
    再用@PathVariable，将占位符标识的值和控制器方法的形参进行绑定。
 */

@Controller
@RequestMapping("/test") //设置请求映射的基础信息
public class TestRequestMappingController {

    //只有表单提交的请求方式是POST，剩下全部是GET
    @RequestMapping(value = {"/hello", "/bennett"},
                    method = RequestMethod.GET) //设置请求映射的具体信息
    public String hello() {
        return "success";
    }

    //@RequestMapping("/a?a/ant")
    //@RequestMapping("/a*a/ant")
    @RequestMapping("/**/ant")
    public String testAnt() {
        return "success";
    }

    @RequestMapping("/restful/{username}/{id}")
    public String testRestful(@PathVariable("id") Integer id, @PathVariable("username") String userName) {
        System.out.println("id: " + id);
        System.out.println("username: " + userName);
        return "success";
    }

}
