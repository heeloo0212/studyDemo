package com.test.demo.test.springEvent;

import com.test.demo.test.UserEntity;
import org.springframework.context.ApplicationEvent;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/5/6 8:41
 */
public class BaseUserEventer extends ApplicationEvent {

    private UserEntity user;

    public BaseUserEventer(UserEntity source){
        super(source);
        this.user = source;
    }

    public UserEntity getUser(){
        return user;
    }

}
