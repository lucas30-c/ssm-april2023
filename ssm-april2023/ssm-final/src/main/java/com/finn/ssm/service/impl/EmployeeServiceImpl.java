package com.finn.ssm.service.impl;

import com.finn.ssm.mapper.EmployeeMapper;
import com.finn.ssm.pojo.Employee;
import com.finn.ssm.service.EmployeeService;
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
}
