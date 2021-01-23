package com.mp.test.day08MetaObjectHandlerTest;

import com.mp.entity.User;
import com.mp.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MetaObjectHandlerTest {

    ApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext.xml");

    UserMapper userMapper = ctx.getBean("userMapper",UserMapper.class);

    /**
     * 测试公共字段填充 (insert)
     */
    @Test
    public void testInsert() {

        User user = new User();
        user.setLogicFlag(1);
        userMapper.insert(user);

    }

    /**
     * 测试公共字段填充 (update)
     */
    @Test
    public void testUpdate() {

        User user = new User();
        user.setId(4);
        user.setLogicFlag(1);
        userMapper.updateById(user);

    }

}
