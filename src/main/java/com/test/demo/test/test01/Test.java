package com.test.demo.test.test01;


import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/9/9 16:27
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(getRandNumber());
    }

    public static String getRandNumber(){
        StringBuffer numStr = new StringBuffer();
        int num;
        for(int i=0;i<6;i++){
            num = (int)(Math.random()*10);
            System.out.println("数字"+num);
            numStr.append(num);
        }
        return numStr.toString();
    }

}

