package com.mp.test.day03AR;

import com.mp.entity.EmployeeModel;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateTest {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * AR 修改操作
     */
    @Test
    public void testARUpdate() {

        EmployeeModel employee = new EmployeeModel();
        employee.setId(10);
        employee.setLastName("宋老湿");
        employee.setEmail("sls@atguigu.com");
        employee.setGender(1);
        employee.setAge(36);

        boolean result = employee.updateById();
        System.out.println("result:" + result);

    }

}
