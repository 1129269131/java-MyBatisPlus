package com.mp.test.day03AR;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mp.entity.Employee;
import com.mp.entity.EmployeeModel;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SelectTest {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * AR 查询操作 (SelectById)
     */
    @Test
    public void testSelectById01() {

        EmployeeModel employee = new EmployeeModel();
        EmployeeModel result = employee.selectById(10);
		System.out.println(result);

    }

    /**
     * AR 查询操作 (SelectById)
     */
    @Test
    public void testSelectById02() {

        EmployeeModel employee = new EmployeeModel();
        employee.setId(10);
        EmployeeModel result = employee.selectById();
        System.out.println(result);

    }

    /**
     * AR 查询操作 (SelectAll)
     */
    @Test
    public void testSelectAll() {

        EmployeeModel employee = new EmployeeModel();
        List<EmployeeModel> emps = employee.selectAll();
        System.out.println(emps );

    }

    /**
     * AR 查询操作 (EntityWrapperSelect)
     */
    @Test
    public void testEntityWrapperSelect() {

        EmployeeModel employee = new EmployeeModel();
        List<EmployeeModel > emps =
				employee.selectList(new EntityWrapper<Employee>().like("last_name", "老师"));
		System.out.println(emps);

    }

    /**
     * AR 查询操作 (SelectCount)
     */
    @Test
    public void testSelectCount() {

        EmployeeModel employee = new EmployeeModel();
        Integer result = employee.selectCount(new EntityWrapper<Employee>().eq("gender", 0));
        System.out.println("result: " + result);

    }

    /**
     * AR  分页复杂操作 (分页查询)
     */
    @Test
    public void  testARPage() {

        EmployeeModel employee = new EmployeeModel();
        Page<EmployeeModel> page = employee.selectPage(new Page<EmployeeModel>(1, 1),
                new EntityWrapper<EmployeeModel>().like("last_name", "老"));
        List<EmployeeModel> emps = page.getRecords();
        System.out.println(emps);

    }

}
