package com.finn.ssm.test;

import com.finn.ssm.mapper.EmployeeMapper;
import com.finn.ssm.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import java.util.List;

@SpringJUnitConfig
@ContextConfiguration("classpath:Spring.xml") //你的Spring配置文件的路径
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testGetAllEmployees() {
        List<Employee> employees = employeeMapper.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
