package com.mp.test.day05PluginTest;

import com.mp.entity.Employee;
import com.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OptimisticLockerTest {

    ApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = ctx.getBean("employeeMapper",EmployeeMapper.class);

    /**
     * 测试 乐观锁插件
     */

    @Test
    public void testOptimisticLocker() {

        //更新操作
        Employee employee = new Employee();
        employee.setId(15);
        employee.setLastName("TomAA");
        employee.setEmail("tomAA@sina.com");
        employee.setGender(1);
        employee.setAge(22);
        employee.setVersion(3);

        employeeMapper.updateById(employee);

    }

}
