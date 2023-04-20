package com.finn.dao;

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
}
