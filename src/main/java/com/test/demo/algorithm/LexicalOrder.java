package com.test.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe: 386. 字典序排数
 * @Author: yangqingfang
 * @Date: 2022/4/18 14:00
 */
public class LexicalOrder {

    public static void main(String[] args) {
        List<Integer> list = lexicalOrderMethod(192);
        System.out.println(list.size());
        System.out.println(list);
    }

    public static List<Integer> lexicalOrderMethod(int n){
        List<Integer> list = new ArrayList<>();
        int num = 1;
        for(int i=0;i<n;i++){
            list.add(num);
            if(num * 10 <= n){
                num *= 10;
            }else{
                while (num % 10 == 9 || num + 1 > n) {
                    num /= 10;
                }
                num ++;
            }
        }
        return list;
    }

    //官方题解
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            ret.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return ret;
    }




}
