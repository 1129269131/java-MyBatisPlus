package com.mp.test.day05PluginTest;

import com.baomidou.mybatisplus.plugins.Page;
import com.mp.entity.Employee;
import com.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PaginationTest {

    ApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = ctx.getBean("employeeMapper",EmployeeMapper.class);

    /**
     * 测试分页插件
     */
    @Test
    public void testPage() {

        Page<Employee> page = new Page<Employee>(1,1);
        List<Employee> emps =
                employeeMapper.selectPage(page, null);
        System.out.println(emps);

        System.out.println("===============获取分页相关的一些信息======================");

        System.out.println("总条数:" +page.getTotal());
        System.out.println("当前页码: "+  page.getCurrent());
        System.out.println("总页码:" + page.getPages());
        System.out.println("每页显示的条数:" + page.getSize());
        System.out.println("是否有上一页: " + page.hasPrevious());
        System.out.println("是否有下一页: " + page.hasNext());

        //将查询的结果封装到page对象中
        page.setRecords(emps);

    }

}
