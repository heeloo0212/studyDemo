package com.test.demo.web.service;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/5/6 11:55
 */
@Service
public class AspectService {

    public void aspectTest(){
        System.out.println("。。。。方法进行中。。。。");
    }

}
