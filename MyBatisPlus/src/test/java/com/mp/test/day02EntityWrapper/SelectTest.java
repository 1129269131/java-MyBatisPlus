package com.mp.test.day02EntityWrapper;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mp.entity.Employee;
import com.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class SelectTest {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper employeeMapper =
            ioc.getBean("employeeMapper",EmployeeMapper.class);


    /**
     * 条件构造器   查询操作(EntityWrapper实现 between，eq)
     */
    @Test
    public void testEntityWrapperBetweenEqSelect() {

        //我们需要分页查询tbl_employee表中，年龄在18~50之间且性别为男且姓名为Tom的所有用户
		List<Employee> emps =employeeMapper.selectPage(new Page<Employee>(1, 2),
					new EntityWrapper<Employee>()
					.between("age", 18, 50)
					.eq("gender", 1)
					.eq("last_name", "Tom")
				);
		System.out.println(emps);

    }

    /**
     * 条件构造器   查询操作(Condition实现 between，eq)
     */
    @Test
    public void testConditionBetweenEqSelect() {

        //我们需要分页查询tbl_employee表中，年龄在18~50之间且性别为男且姓名为Tom的所有用户
        List<Employee> emps =employeeMapper.selectPage(new Page<Employee>(1, 2),
                Condition.create()
                        .between("age", 18, 50)
                        .eq("gender", 1)
                        .eq("last_name", "Tom")
        );
        System.out.println(emps);

    }

    /**
     * 条件构造器   查询操作(Or)
     */
    @Test
    public void testOr() {

        // 查询tbl_employee表中， 性别为女并且名字中带有"老师" 或者  邮箱中带有"a"
		List<Employee> emps = employeeMapper.selectList(
				new EntityWrapper<Employee>()
				.eq("gender", 0)
				.like("last_name", "老师")
				//.or()    // SQL: (gender = ? AND last_name LIKE ? OR email LIKE ?)
				.orNew()   // SQL: (gender = ? AND last_name LIKE ?) OR (email LIKE ?)
				.like("email", "a")
				);
		System.out.println(emps);;

    }

    /**
     * 条件构造器   查询操作(Asc)
     */
    @Test
    public void testAsc() {

        // 查询性别为女的, 根据age进行排序(asc)
		List<Employee> emps  = employeeMapper.selectList(
				new EntityWrapper<Employee>()
				.eq("gender", 0)
				.orderBy("age")
				);
		System.out.println(emps);

    }

    /**
     * 条件构造器   查询操作(Desc)
     */
    @Test
    public void testDesc() {

        // 查询性别为女的, 根据age进行排序(desc)
        List<Employee> emps  = employeeMapper.selectList(
                new EntityWrapper<Employee>()
                        .eq("gender", 0)
                        .orderBy("age")
                        .orderDesc(Arrays.asList(new String [] {"age"}))
        );
        System.out.println(emps);

    }

    /**
     * 条件构造器   查询操作(.last: 在SQL语句最后直接加入，所以有sql注入风险，慎用!!!)
     */
    @Test
    public void testLast() {

        // 查询性别为女的, 根据age进行排序(desc), 简单分页
        List<Employee> emps  = employeeMapper.selectList(
                new EntityWrapper<Employee>()
                        .eq("gender", 0)
                        .orderBy("age")
                        .last("desc limit 1,3")
        );
        System.out.println(emps);

    }
}
