package com.test.demo.algorithm;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 *
 * 请你计算并返回该式的最大值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,2]
 * 输出：12
 * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
 */
public class MaxProduct_1464 {

    public static void main(String[] args) {
        int[] arr = {3,4,5,2};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums){
        Arrays.sort(nums);
        return (nums[nums.length-2]-1) * (nums[nums.length-1]-1);
    }


}
