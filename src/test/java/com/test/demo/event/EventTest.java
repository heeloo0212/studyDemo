package com.test.demo.event;

import com.test.demo.test.UserEntity;
import com.test.demo.test.springEvent.BaseUserEventer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/5/6 8:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EventTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void EventTest(){
        applicationContext.publishEvent(new BaseUserEventer(new UserEntity()));
    }

}
