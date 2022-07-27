package com.test.demo.test.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/5/6 9:07
 */
@Component
@Aspect
public class BeforeAndAfter {

    @AfterReturning(value = "execution(* com.test.demo.web.service.AspectService*.aspectTest(..))",returning = "result")
    public void after(JoinPoint joinPoint,Object result){
        //Object[] args = joinPoint.getArgs();

        System.out.println("方法后置返回处理");
    }

    @Before(value = "execution(* com.test.demo.web.service.AspectService*.aspectTest(..))")
    public void before(JoinPoint joinPoint){
        //Object[] args = joinPoint.getArgs();

        System.out.println("方法前置处理");
    }
}
