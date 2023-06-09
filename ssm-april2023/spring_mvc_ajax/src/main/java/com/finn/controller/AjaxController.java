package com.finn.controller;

import com.finn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class AjaxController {

    @RequestMapping("test/ajax")
    public void testAjax(Integer id, HttpServletResponse response, @RequestBody String requestBody) throws IOException {
        System.out.println("RequestBody: " + requestBody);
        System.out.println("id:" + id);
        response.getWriter().write("hello, axios"); //涉及到流
        /*
                    当客户端（浏览器）通过ajax发起POST请求到/SpringMVC/test/ajax?id=1001时，
                    服务器接收到这个请求，并将其路由到controller里的testAjax方法处理。
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

    /*
        使用@RequestBody注解将json格式的请求参数转换为java对象
        a. 导入jackson依赖
        b. 在SpringMVC的配置文件中设置<mvc:annotation-driven />
        c. 在处理请求的控制器方法的形参位置，直接设置json格式的请求参数要转换的java类型的形参
     */
    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException {
        System.out.println(map); //只打印有数据的部分
        response.getWriter().write("Hello, RequestBody.");
    }
    //这两种写法基本等效

//    @RequestMapping("/test/RequestBody/json")
//    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
//        System.out.println(user);
//        response.getWriter().write("Hello, RequestBody.");
//    }

    /*
        @ResponseBody: 将所标识的控制器方法的返回值作为响应报文的响应体响应到浏览器
        用的非常多！
        以后响应的一般是一个java对象

        使用@ResponseBody响应浏览器json格式的数据
        a. 导入jackson依赖
        b. 在SpringMVC的配置文件中设置<mvc:annotation-driven />
        c. 将需要转换为json字符串的java对象直接作为控制器方法的返回值，使用@RequestBody注解标识控制器方法，
           就可以将java对象转换为json字符串，并响应到浏览器。

        常用的Java对象转换为json的结果：
        实体类，map一律转为json对象
        list转为json数组
     */

    /*
        testResponseBody方法返回了一个字符串"Hello Finn"。由于testResponseBody方法被@ResponseBody注解修饰，Spring MVC将直接将这个字符串写入HTTP响应的body，而不是尝试找到名为"success"的视图。因此，浏览器将接收到一个只包含"success"的HTTP响应。
        在浏览器中，你将看到一个只有"Hello Finn"文字的页面。
     */
        /*
            "hello world" 就是 HTTP 响应的 body。
            使用了 @ResponseBody 注解后，Spring 会将方法的返回值作为 HTTP 响应的 body，
            并且默认会把这个 body 的内容类型设置为 text/plain，
            然后直接发送给客户端（在这个例子中，客户端就是你的浏览器）。
         */
    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "Hello, Finn!";
    }

    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public User testResponseBodyJson() {
        User user = new User(1001, "admin", "12345", 20, "Male");
        return user;
        //把user通过json的格式响应出去
    }
}
