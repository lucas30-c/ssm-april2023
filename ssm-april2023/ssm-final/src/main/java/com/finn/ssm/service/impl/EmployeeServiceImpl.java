package com.finn.ssm.service.impl;

import com.finn.ssm.mapper.EmployeeMapper;
import com.finn.ssm.pojo.Employee;
import com.finn.ssm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired //必须要依赖注入，否则出现空指针异常！
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeMapper.getAllEmployees();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum, 6);
        //查询所有员工信息
        List<Employee> list = employeeMapper.getAllEmployees();
        //获取分页相关数据
        PageInfo<Employee> page = new PageInfo<>(list, 5);
        return page;
    }
}
