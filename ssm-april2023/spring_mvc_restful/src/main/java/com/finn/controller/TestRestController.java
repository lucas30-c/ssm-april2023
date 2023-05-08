package com.finn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * get 查询
 * post 添加(增)
 * delete 删除
 * put 修改(更新)
 *
 * 查询所有的用户信息: /user->get    (一层)
 * 根据id查询用户信息: /user/1->get (两层)
 * 添加用户信息: /user->post
 * 查询所有的用户信息: /user->get
 * 修改用户信息: /user->put
 * 删除用户信息: /user/1->delete
 *
 * 注意: 浏览器目前只能发送get和post请求
 * 如果要发送put和delete请求,需要在web.xml中配置一个过滤器HiddenHttpMethodFilter
 * 配置了过滤器后,发送的请求要满足两个条件,才能将请求方式转化为put或delete
 * 1. 当前请求必须为post
 * 2. 当前请求必须传输请求参数_method,_method才是最终的请求方式. （这点非常重要！）
 *
 * Spring Framework 提供了一个名为 HiddenHttpMethodFilter 的过滤器，
 * 可以让您使用一个隐藏的 _method 参数来指定实际的 HTTP 方法。
 * 这个过滤器会将请求重新包装为 PUT、DELETE 或其他 HTTP 方法，
 * 从而允许您在服务器端处理这些类型的请求。
 */

@Controller
public class TestRestController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUsers() {
        System.out.println("查询所有用户:" +
                "@RequestMapping(value = \"/user\", method = RequestMethod.GET)");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id) {
        System.out.println("根据id查询用户信息 -> /user/" + id + "->get");
        return "success";
    }

    //添加用Post
    @RequestMapping(value="/user", method = RequestMethod.POST)
    public String insertUser() {
        System.out.println("添加用户信息");
        return "success";
    }

    @RequestMapping(value="/user", method=RequestMethod.PUT)
    public String updateUser() {
        System.out.println("修改用户信息->/user->delete");
        return "success";
    }

    @RequestMapping(value="/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id) {
        System.out.println("删除用户信息->/user->put");
        return "success";
    }
}
