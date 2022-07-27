package com.test.demo.test.aspect;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/5/6 9:27
 */
public class Target {

    public Target(){
        targetMethod();
    }

    public void targetMethod(){
        System.out.println("处理方法");
    }

}
