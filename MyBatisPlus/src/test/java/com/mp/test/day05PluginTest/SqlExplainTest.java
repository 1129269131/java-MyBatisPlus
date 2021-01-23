package com.mp.test.day05PluginTest;

import com.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SqlExplainTest {

    ApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = ctx.getBean("employeeMapper",EmployeeMapper.class);

    /**
     * 测试SQL执行分析插件
     */
    @Test
    public void testSQLExplain() {

        employeeMapper.delete(null);  // 全表删除

    }


}
