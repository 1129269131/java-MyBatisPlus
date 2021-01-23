package com.mp.test.day06AutoSqlInjectorTest;

import com.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySqlInjectorTest {

    ApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = ctx.getBean("employeeMapper",EmployeeMapper.class);

    /**
     * 测试自定义全局操作
     */
    @Test
    public void  testMySqlInjector() {

        Integer result = employeeMapper.deleteAll();
        System.out.println("result: " +result );

    }

}
