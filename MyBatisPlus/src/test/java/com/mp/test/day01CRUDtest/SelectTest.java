package com.mp.test.day01CRUDtest;

import com.baomidou.mybatisplus.plugins.Page;
import com.mp.entity.Employee;
import com.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectTest {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper employeeMapper =
            ioc.getBean("employeeMapper",EmployeeMapper.class);

    /**
     * 通用 查询操作(通过id查询)
     */
    @Test
    public void testCommonSelect(){

        Employee employee = employeeMapper.selectById(1);
        System.out.println(employee);

    }

    /**
     * 通用 查询操作(通过多个列查询)
     */
    @Test
    public void testSelectOne(){

        Employee employee = new Employee();
        employee.setId(7);
        employee.setLastName("小泽老师");

        Employee result = employeeMapper.selectOne(employee);
        System.out.println(employee);

    }

    /**
     * 通用 查询操作(通过多个id进行查询)
     */
    @Test
    public void testSelectBatchIds(){

        List<Integer> idList = new ArrayList<Integer>();
        idList.add(4);
        idList.add(5);
        idList.add(6);

        List<Employee> emps = employeeMapper.selectBatchIds(idList);
        System.out.println(emps);

    }

    /**
     * 通用 查询操作(通过Map封装条件查询)
     */
    @Test
    public void testSelectByMap(){

        Map<String,Object> columnMap = new HashMap<String, Object>();
        columnMap.put("last_name","小泽老师");
        columnMap.put("gender",0);

        List<Employee> emps = employeeMapper.selectByMap(columnMap);
        System.out.println(emps);

    }

    /**
     * 通用 查询操作(分页查询)
     */
    @Test
    public void testSelectPage(){

        List<Employee> emps = employeeMapper.selectPage(new Page<Employee>(2,2),null);
        System.out.println(emps);

    }
}
