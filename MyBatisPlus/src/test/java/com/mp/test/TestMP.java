package com.mp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

/* 测试数据库连接，无实际作用 */
public class TestMP {

    private ApplicationContext ioc =
                new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testDataSource() throws Exception{

        DataSource ds = ioc.getBean("dataSource",DataSource.class);
        System.out.println(ds);

        Connection conn = ds.getConnection();
        System.out.println(conn);

    }

}
