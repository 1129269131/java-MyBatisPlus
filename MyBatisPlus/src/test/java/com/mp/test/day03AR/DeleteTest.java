package com.mp.test.day03AR;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mp.entity.EmployeeModel;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DeleteTest {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * AR 删除操作 (deleteById)
     *
     * 注意: 删除不存在的数据 逻辑上也是属于成功的.
     */
    @Test
    public void testARDeleteById01() {

        EmployeeModel employee = new EmployeeModel();
        boolean result = employee.deleteById(10);
        System.out.println("result:" + result);

    }

    /**
     * AR 删除操作 (deleteById)
     *
     * 注意: 删除不存在的数据 逻辑上也是属于成功的.
     */
    @Test
    public void testARDeleteById02() {

        EmployeeModel employee = new EmployeeModel();
        employee.setId(10);
        boolean result = employee.deleteById();
        System.out.println("result:" + result);

    }

    /**
     * AR 删除操作 (EntityWrapper)
     *
     * 注意: 删除不存在的数据 逻辑上也是属于成功的.
     */
    @Test
    public void testARDelete() {

        EmployeeModel employee = new EmployeeModel();
        boolean result = employee.delete(new EntityWrapper<EmployeeModel>().like("last_name", "小"));
        System.out.println(result);
    }

}
