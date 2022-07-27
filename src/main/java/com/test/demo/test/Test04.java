package com.test.demo.test;

import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/6/20 9:12
 */
public class Test04 {

    public static void main(String[] args) throws Exception {

//        Properties properties = System.getProperties();
//        System.out.println(properties);
//
        System.out.println(InetAddress.getLocalHost().getHostAddress()+"@"+Thread.currentThread());

        String url = "http://"+InetAddress.getLocalHost().getHostAddress()+":8080";
        URL url1 = new URL(url);
        System.out.println(url1.getHost()+"   "+url1.getPort());


    }

}
