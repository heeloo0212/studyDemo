package com.test.demo.test;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/3/29 9:22
 */
public class TestException {

    public static void main(String[] args) throws Exception{
        TestException testException = new TestException();
        testException.testMethod(23);
    }

    public void testMethod(Integer score) throws Exception{
        if(score < 60){
           throw new MyException("分数不及格");
        }else {
            System.out.println(score);
        }
    }

}
