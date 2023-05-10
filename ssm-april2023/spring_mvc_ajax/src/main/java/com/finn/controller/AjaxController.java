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
        /*
                    当客户端（浏览器）通过ajax发起POST请求到/SpringMVC/test/ajax?id=1001时，
                    服务器接收到这个请求，并将其路由到vue里的testAjax方法处理。
                    这个方法接收两个参数：一个是id，它从查询字符串参数中提取；
                    另一个是HttpServletResponse，它代表服务器对客户端的响应。

        */
    }

    /*
        response.getWriter().write("hello, axios")这行代码的作用是将字符串"hello, axios"写入到HTTP响应的主体。

        当你的服务器（在这个例子中是Spring MVC）收到一个HTTP请求时，
        它会创建一个HttpServletResponse对象。
        这个对象代表服务器发送回客户端的HTTP响应。
        你可以使用HttpServletResponse对象的方法来设置响应的状态码、头部字段和主体。

        在这个例子中，你使用response.getWriter()方法获取了一个PrintWriter对象，
        然后使用PrintWriter.write方法将字符串"hello, axios"写入到响应的主体。

        当你的controller方法结束时，Spring MVC会将HttpServletResponse对象转换为一个HTTP响应，
        并将其发送回客户端（在这个例子中是浏览器）。

        因此，这个输出流的“流向”是客户端。当客户端收到这个响应时，
        它可以读取响应的主体来获取服务器发送的数据（在这个例子中是"hello, axios"）。

     */
}
