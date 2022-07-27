package com.test.demo.test;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/3/23 9:27
 */
public class ParamThreePoint {

    public static void main(String[] args) {
        threePoint("111","222","6666");

    }

    public static void threePoint(String... str){
        for(String s : str) {
            System.out.println(s);
        }
    }

}
