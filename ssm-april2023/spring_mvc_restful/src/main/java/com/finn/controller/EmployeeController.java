package com.finn.controller;

import com.finn.dao.EmployeeDao;
import com.finn.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 *
 *查询所有员工信息 -> /employee->get
 * 跳转到添加页面 -> /to/add->get
 * 添加员工信息 -> /employee->post
 * 跳转到修改页面 -> /employee/1->get
 * 修改员工信息 -> /employee->put
 * 删除员工信息 -> /employee/1 -> delete
 */

@Controller
public class EmployeeController {
    //深入理解注解+扫描 注解没问题一般就是扫描的问题.
    //防止自动装配报错
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployees(Model model) {
        //获取所有的员工信息
        Collection<Employee> allEmployees = employeeDao.getAll();
        //将所有的员工信息在请求域中共享
        model.addAttribute("allEmployees", allEmployees);

        return "employees_list";
    }

    //添加用POST
    /*
        value参数定义了请求的URL路径。在这里，它被设置为"/employee"。
        这意味着当客户端向服务器发送一个请求，且请求的URL路径为"/employee"时，这个方法将被调用。
     */
    /*
    通过将这两个参数配置为上述值，这个控制器方法遵循了RESTful风格的API设计原则。
    当客户端通过一个POST请求和"/employee"路径访问此方法时，服务器将执行添加员工信息的操作，
    然后重定向到员工列表页面。
     */
    @RequestMapping(value = "/employee/a", method = RequestMethod.POST)
    public String addEmployee(Employee employee) {
        //保存员工信息
        employeeDao.save(employee);
        //重定向到列表功能：/employee
        return "redirect:/employee"; //重定向
    }
}
