package com.mp.test.day01CRUDtest;

import com.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteTest {

    private ApplicationContext ioc =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper employeeMapper =
            ioc.getBean("employeeMapper",EmployeeMapper.class);

    /**
     * 通用 查询操作(根据id进行删除)
     */
    @Test
    public void testDeleteById(){

        Integer result = employeeMapper.deleteById(7);
        System.out.println(result);

    }

    /**
     * 通用 查询操作(根据条件进行删除)
     */
    @Test
    public void testDeleteByMap(){

        Map<String,Object> columnMap = new HashMap<String, Object>();
        columnMap.put("last_name", "MP");
        columnMap.put("email","mp@atguigu.com");
        Integer result = employeeMapper.deleteByMap(columnMap);
        System.out.println(result);

    }

    /**
     * 通用 查询操作(批量删除)
     */
    @Test
    public void testDeleteBatchIds(){

        List<Integer> idList = new ArrayList<Integer>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        Integer result = employeeMapper.deleteBatchIds(idList);
        System.out.println(result);

    }
}
