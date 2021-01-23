package com.mp.test.day05PluginTest;

import com.mp.entity.Employee;
import com.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PerformanceTest {

    ApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = ctx.getBean("employeeMapper",EmployeeMapper.class);

    /**
     * 测试 性能分析插件
     */
    @Test
    public void testPerformance() {

        Employee employee = new Employee();
        employee.setLastName("玛利亚老师");
        employee.setEmail("mly@sina.com");
        employee.setGender(0);
        employee.setAge(22);

        employeeMapper.insert(employee);

    }

}
