package com.test.demo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Describe: 1437. 是否所有 1 都至少相隔 k 个元素
 * @Author: yangqingfang
 * @Date: 2022/4/13 11:46
 */
public class KLengthApart {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1};
        System.out.println(kLengthApartMethod(nums,0));
    }

    public static Boolean kLengthApartMethod(int[] nums,int k){
        //List<Integer> list = new ArrayList<>();
        int index = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                if(index>=0 && i-index-1<k){
                    return false;
                }
                index = i;
            }
        }

        return true;
    }

}
