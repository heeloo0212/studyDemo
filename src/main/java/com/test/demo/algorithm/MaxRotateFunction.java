package com.test.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/4/22 13:14
 * 396. 旋转函数
 *给定一个长度为 n 的整数数组 nums 。
 *
 * 假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数  F 为：
 *
 * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
 * 返回 F(0), F(1), ..., F(n-1)中的最大值 。
 *
 * 生成的测试用例让答案符合 32 位 整数。
 *
 * 输入: nums = [4,3,2,6]
 * 输出: 26
 * 解释:
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 */
public class MaxRotateFunction {

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,6};
        System.out.println(maxRotateFunctionMethod(nums));

    }

    //超时（移动数组）
    public static int maxRotateFunctionMethod(int[] nums){
        int length = nums.length;
        int next = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<length;i++){
            int calculation = calculation(nums);
            System.out.println(calculation);
            list.add(calculation);
            for(int j=0;j<length;j++){
                //旋转数组
                if(j==0){
                    next = nums[j];
                }else{
                    int temp = nums[j];
                    nums[j] = next;
                    next = temp;
                }
            }
            nums[0] = next;
        }
        return list.stream().max(Integer::compareTo).get();
    }

    public static int calculation(int[] nums){
        int length = nums.length;
        int num = 0;
        for(int i=0;i<length;i++){
            num += i*nums[i];
        }
        return num;
    }



}
