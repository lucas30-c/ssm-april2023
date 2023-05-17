package com.finn.ssm.controller;

import com.finn.ssm.pojo.Employee;
import com.finn.ssm.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*
    查询所有的员工信息 --> /employee-->get
    查询员工的分页信息 --> /employee/page/1-->get
    根据id查询员工信息 --> /employee/1-->get
    跳转到添加页面 --> /to/add-->get
    添加员工信息 --> /employee-->post
    修改员工信息 --> /employee-->put
    删除员工信息 --> /employee/i --> delete
 */

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public String getEmployeesPage(@PathVariable("pageNum") Integer pageNum, Model model) {
        //获取员工的分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        //将分页数据共享到请求域中
        model.addAttribute("page", page);
        //跳转到employee_list.html
        return "employee_list_page";
    }


    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployees(Model model) {
        //查到数据希望展示到页面中就要共享到域对象里——Model
        List<Employee> list = employeeService.getAllEmployees();
        //将员工信息在请求域中共享
        model.addAttribute("list", list);
        //跳转到employee_list.html
        return "employee_list";
    }
}
