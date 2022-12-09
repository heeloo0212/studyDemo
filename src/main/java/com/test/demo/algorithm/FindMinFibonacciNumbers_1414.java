package com.test.demo.algorithm;

/**
 * <p>
 * 1414. 和为 K 的最少斐波那契数字数目
 * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
 *
 * 斐波那契数字定义为：
 *
 * F1 = 1
 * F2 = 1
 * Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
 * 数据保证对于给定的 k ，一定能找到可行解。
 * </p>
 *
 * @author yangqingfang
 * @since 2022/12/9 10:09
 */
public class FindMinFibonacciNumbers_1414 {

    public static void main(String[] args) {
        FindMinFibonacciNumbers_1414 findMinFibonacciNumbers = new FindMinFibonacciNumbers_1414();
        int minFibonacciNumbers = findMinFibonacciNumbers.findMinFibonacciNumbers(2);
        System.out.println(minFibonacciNumbers);
    }

    public int findMinFibonacciNumbers(int k) {
        int count = 0;
        while(k!=0){
            int n = findThanFibonacci(k);
            k = k - n;
            count++;
        }
        return count;
    }

    public int findThanFibonacci(int n) {
        int f1=1;
        int f2=1;
        while (true){
            int f3 = f1 + f2;
            if(f3 > n){
                break;
            }
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }
}
