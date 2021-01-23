package com.mp.test.day07LogicDeleteTest;

import com.mp.entity.User;
import com.mp.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogicDeleteTest {

    ApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext.xml");

    UserMapper userMapper = ctx.getBean("userMapper",UserMapper.class);

    /**
     * 测试逻辑删除
     */
    @Test
    public void testLogicDelete() {

		Integer result = userMapper.deleteById(1);
		System.out.println("result:" +result );

        User user = userMapper.selectById(1);
        System.out.println("select:"+user);

    }

}
