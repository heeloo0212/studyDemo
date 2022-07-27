package com.test.demo.test;

import org.springframework.util.Assert;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/4/6 18:14
 */
public class Test2 {

    public static void main(String[] args) {

        String url = "/hht/122774?strat=jdfdjf";
        System.out.println(url.split("/")[2].split("\\?")[0]);
    }

}
