package com.test.demo.test;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/4/8 13:45
 */
public class Test3 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,6};
        int next = 0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                next = nums[i];
            }
            if(i>0 && i < nums.length) {
                int temp = nums[i];
                nums[i] = next;
                next = temp;
            }
        }
        nums[0] = next;
        Arrays.stream(nums).forEach(e ->{
            System.out.println(e);
        });
    }

}
