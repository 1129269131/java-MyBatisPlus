package com.mp.test.day03AR;

import com.mp.entity.EmployeeModel;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InsertTest {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * AR  插入操作
     */
    @Test
    public void  testARInsert() {

        EmployeeModel employee = new EmployeeModel();
        employee.setLastName("宋老师");
        employee.setEmail("sls@atguigu.com");
        employee.setGender(1);
        employee.setAge(35);

        boolean result = employee.insert();
        System.out.println("result:" + result);

    }

}
