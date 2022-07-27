package com.test.demo.test;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/4/19 8:42
 */
public class HashMapAnay {

    public static void main(String[] args) {
        System.out.println(2^4);
    }

    //计算hashmap的key值
    public static void keyToHashCode(Object key){
        int h;
        //return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(key.hashCode());
        System.out.println((h = key.hashCode()) ^ (h >>> 16));
        System.out.println((key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16));
    }

}
