package com.mp.test.day01CRUDtest;

import com.mp.entity.Employee;
import com.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InsertTest {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper employeeMapper =
            ioc.getBean("employeeMapper",EmployeeMapper.class);

    /**
     * 通用 插入操作(非空字段插入)
     */
    @Test
    public void testCommonInsert(){

        // 初始化Employee对象
        Employee employee = new Employee();
        employee.setLastName("MP");
        employee.setEmail("mp@atguigu.com");
        employee.setGender(1);
        employee.setAge(22);
        // insert方法在插入时， 会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现到SQL语句中
        Integer result = employeeMapper.insert(employee);
        System.out.println("result: " + result);

        // 获取当前数据在数据库中的主键值
        Integer key = employee.getId();
        System.out.println("key: " + key);

    }

    /**
     * 通用 插入操作(全字段插入)
     */
    @Test
    public void testInsertAllColumn(){

        // 初始化Employee对象
        Employee employee = new Employee();
        employee.setLastName("MP");
        employee.setEmail("mp@atguigu.com");
        /*employee.setGender(1);
        employee.setAge(22);*/
        // insertAllColumn方法在插入时， 不管属性是否非空， 属性所对应的字段都会出现到SQL语句中.
        Integer result = employeeMapper.insertAllColumn(employee);
        System.out.println("result: " + result);

        // 获取当前数据在数据库中的主键值
        Integer key = employee.getId();
        System.out.println("key: " + key);

    }

}
