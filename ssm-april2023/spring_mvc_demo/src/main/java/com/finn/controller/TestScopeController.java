package com.finn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/*
    向请求域对象共享数据
    1. 通过ModelAndView向请求域共享数据
    使用ModelAndView时，可以使用Model功能向请求域共享数据
    使用View功能设置逻辑视图，但是控制器方法一定要将ModelAndView作为方法的返回值。
    2. 使用Model向请求域共享数据
    3. 使用ModelMap向请求域共享数据
    4. 使用map向请求域共享数据

    2-4 本质是一样的，使用org.springframework.validation.support.BindingAwareModelMap
    在底层中这些类型的形参都是通过BindingAwareModelMap创建的。

    在idea中配置preserve sessions across restarts and redeploys，使得重启服务器不会清空session
    回顾：session的钝化和活化。钝化是序列化的过程。
 */
@Controller
public class TestScopeController {

    @RequestMapping("/test/mav")
    public ModelAndView testMAV() {
        /**
         * ModelAndView包含Model和View的功能
         * Model: 向请求域中共享数据
         * View: 设置逻辑视图，实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //向请求域中共享数据（使用addObject方法向请求域中添加数据）
        mav.addObject("testRequestScope", "Hello, ModelAndView");
        //设置逻辑视图
        mav.setViewName("success");
        return mav;

        /*
            这段代码是一个使用Spring MVC框架的简单示例，它演示了如何在控制器中使用ModelAndView对象向请求域共享数据。在这个例子中，有一个名为TestScopeController的控制器类，该类中定义了一个名为testMAV的方法，该方法处理/test/mav的请求。

            域对象（Domain Object）通常指代在Web应用程序的特定范围内存储数据的对象。在Spring MVC中，有三个主要的域对象：请求域（Request Scope）、会话域（Session Scope）和应用域（Application Scope）。这些域对象的生命周期和作用范围各有不同，它们分别对应于HttpServletRequest、HttpSession和ServletContext对象。

            请求域（本节学习的）（Request Scope）：在单次请求中有效，当请求结束时销毁。请求域主要用于存储与特定请求相关的数据。
            会话域（Session Scope）：在整个用户会话期间有效，当会话结束时销毁。会话域用于存储与特定用户会话相关的数据。
            应用域（Application Scope）：在整个应用程序的生命周期内有效，当应用程序关闭时销毁。应用域用于存储全局的、与所有用户共享的数据。
            ModelAndView对象被用于向请求域（Request Scope）共享数据。这意味着，在这个特定请求的上下文中，其他组件（例如视图模板）可以访问这些数据。共享数据的方法如下：

            创建一个ModelAndView对象：ModelAndView mav = new ModelAndView();
            使用addObject方法向请求域中添加数据：mav.addObject("testRequestScope", "hello,ModelAndView");
            设置逻辑视图（在这里是“success”）：mav.setViewName("success");
            将ModelAndView对象作为方法的返回值：return mav;
            当处理请求时，Spring MVC将使用ModelAndView对象中的数据来填充请求域。在这个示例中，将向请求域中添加一个名为testRequestScope的属性，其值为字符串"hello,ModelAndView"。
            这个数据可以在视图（例如JSP、Thymeleaf等）中访问和显示。
         */

    }

    @RequestMapping("/test/model")
    public String testModel(Model model) {
        System.out.println(model.getClass().getName());
        model.addAttribute("testRequestScope", "Hello, Model! This is Finn.");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap) {
        System.out.println(modelMap.getClass().getName());
        //org.springframework.validation.support.BindingAwareModelMap
        modelMap.addAttribute("testRequestScope", "Hello ModelMap!");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map) {
//        System.out.println(map.getClass().getName()); /
        map.put("testRequestScope", "Hello, map!");//org.springframework.validation.support.BindingAwareModelMap
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "Hello, session");
        session.setAttribute("testSessionScope", "Session是一次会话，也即浏览器开启到浏览器关闭的过程");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope", "Hello, application");
        servletContext.setAttribute("testApplicationScope", "应用域是服务器运行的整个过程。");
        return "success";
    }

}


