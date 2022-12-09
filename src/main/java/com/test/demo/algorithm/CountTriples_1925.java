package com.test.demo.algorithm;

/**
 * <p>
 * 1925. 统计平方和三元组的数目
 * 一个 平方和三元组 (a,b,c) 指的是满足 a2 + b2 = c2 的 整数 三元组 a，b 和 c 。
 *
 * 给你一个整数 n ，请你返回满足 1 <= a, b, c <= n 的 平方和三元组 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 5
 * 输出：2
 * 解释：平方和三元组为 (3,4,5) 和 (4,3,5) 。
 * </p>
 *
 * @author yangqingfang
 * @since 2022/10/27 10:00
 */
public class CountTriples_1925 {

    public static void main(String[] args) {
        CountTriples_1925 countTriples = new CountTriples_1925();
        System.out.println(countTriples.countTriples(10));
    }

    public int countTriples(int n) {
        int num = 0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                for(int m=1;m<n+1;m++){
                    if((i*i + j*j) == m*m){
                        num ++;
                    }
                }
            }
        }
        return num;
    }
}
