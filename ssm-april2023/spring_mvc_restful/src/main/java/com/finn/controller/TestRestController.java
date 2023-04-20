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

    @RequestMapping(value="/user", method = RequestMethod.POST)
    public String insertUser() {
        System.out.println("添加用户信息");
        return "success";
    }
}
