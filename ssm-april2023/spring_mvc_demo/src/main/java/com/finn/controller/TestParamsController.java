package com.finn.controller;

import com.finn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
    获取请求参数的方式：
    1. 通过servletAPI获取（原生Servlet）
    只需要在控制器方法的形参处设置HttpServletRequest类型的形参，即可在控制器方法中使用
    request对象获得请求参数。

    2.通过控制器方法的形参获取
    只要在控制器方法的形参位置，设置一个形参，形参名字和请求参数的名字（input标签中的name属性）
    一致即可（必须一致，否则获取不到）。

    3. http://localhost:8048/SpringMVC/param?password=213
    HTTP Status 400 – Bad Request
    Message Required String parameter 'userName' is not present

    @RequestParam: 将请求参数和控制器方法的形参绑定。
    @RequestParam的三个属性：value, required, defaultValue
    value: 设置和形参绑定的请求参数的名字
    required: 设置是否必须传输value对应的请求参数
    默认为true，表示value对应的请求参数必须传输，否则页面报错HTTP Status 400 – Bad Request
    若设置为false，则表示value对应的请求参数不是必须传输，如果未传输，则形参为null
    defaultValue：设置当没有传输value所对应的请求参数时，为形参设置的默认值。此时和required属性值无关。

    4. @RequestHeader: 将请求头信息和控制器方法的形参绑定
    5. @CookieValue: 将cookie数据和控制器方法的形参绑定

    6. 通过控制器方法的实体类类型的形参获取请求参数。（最常用！）
    需要在控制器方法的形参位置设置实体类类型的形参，要保证实体类中属性的属性名和请求参数的名字一致。
    可以通过实体类类型的形参获取请求参数。
 */
@Controller
public class TestParamsController {

    @RequestMapping("/param/servletAPI")
    public String getParamsByServletAPI(HttpServletRequest request) {
        //回顾javaweb
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + ", password: " + password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(@RequestParam(value = "userName", required = true, defaultValue = "finn") String username,
                           String password,
                           @RequestHeader(value = "referer") String referer,
                           @CookieValue("JSESSIONID") String jsessionId) {
        System.out.println("jsessionId: " + jsessionId);
        System.out.println("referer: " + referer);
        System.out.println("username: " + username + ", password: " + password);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user) {
        System.out.println(user);
        return "success";
    }
}
