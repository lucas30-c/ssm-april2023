package com.finn.ssm.service;

import com.finn.ssm.pojo.Employee;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public List<Employee> getAllEmployees();

    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
