package com.test.demo.algorithm;

import java.util.Arrays;

/**
 * @Describe: 1672. 最富有客户的资产总量
 * @Author: yangqingfang
 * @Date: 2022/4/14 10:34
 */
public class MaximumWealth {

    public static void main(String[] args) {
        //int[][] accounts = new int[][]{[1,2,3],[3,2,1]};
        System.out.println();
    }

    public static int maximumWealthMethod(int [][] accounts){
        int max = 0;
        for(int i=0;i<accounts.length;i++){
            int sum = 0;
            for(int j=0;j<accounts[i].length;j++){
                sum += accounts[i][j];
            }
            if(sum >= max){
                max = sum;
            }
        }
        return max;

    }
}
