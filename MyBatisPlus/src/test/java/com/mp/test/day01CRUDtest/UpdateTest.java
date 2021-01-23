package com.mp.test.day01CRUDtest;

import com.mp.entity.Employee;
import com.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateTest {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper employeeMapper =
            ioc.getBean("employeeMapper",EmployeeMapper.class);

    /**
     * 通用 更新操作(非空字段插入)
     */
    @Test
    public void testCommonUpdate() {

        // 初始化修改对象
        Employee employee = new Employee();
        employee.setId(7);
        employee.setLastName("小泽老师");
        employee.setEmail("xz@sina.com");
        employee.setGender(0);
        // employee.setAge(33);

        Integer result = employeeMapper.updateById(employee);
        System.out.println("result: " + result );

    }

    /**
     * 通用 更新操作(全字段插入)
     */
    @Test
    public void testUpdateAllColumnById() {

        // 初始化修改对象
        Employee employee = new Employee();
        employee.setId(6);
        employee.setLastName("小泽老师");
        employee.setEmail("xz@sina.com");
        employee.setGender(0);
        // employee.setAge(33);

        Integer result = employeeMapper.updateAllColumnById(employee);
        System.out.println("result: " + result );

    }
}
