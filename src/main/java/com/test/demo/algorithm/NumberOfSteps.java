package com.test.demo.algorithm;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/4/19 17:24
 */
public class NumberOfSteps {

    public static void main(String[] args) {
        //14->7->6->3->2->1->0
        System.out.println(numberOfStepsMethod(8));
    }

    public static int numberOfStepsMethod(int nums){
        int step = 0;
        if(nums == 0){
            return step;
        }
        return numberOfSteps(nums,step);
    }

    public static int numberOfSteps(int nums,int step){
        if(nums % 2 == 0){
            nums = nums >> 1;
        }else{
            nums = nums - 1;
        }
        step += 1;
        if(nums == 0){
            return step;
        }
        return numberOfSteps(nums, step);
    }

}
