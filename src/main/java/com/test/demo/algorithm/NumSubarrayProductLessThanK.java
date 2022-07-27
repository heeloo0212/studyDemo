package com.test.demo.algorithm;

/**
 * @Describe: 713. 乘积小于 K 的子数组
 * @Author: yangqingfang
 * @Date: 2022/5/5 18:46
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 *  
 * 示例 1：
 *
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 */
public class NumSubarrayProductLessThanK {

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        int i = numSubarrayProductLessThanKMethod(nums, 19);
        System.out.println(i);
    }

    public static int numSubarrayProductLessThanKMethod(int[] nums, int k){
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int multipart = nums[i];
            if(multipart < k){
                count ++;
            }
            for(int j=i+1;j<nums.length;j++){
                multipart *= nums[j];
                if(multipart < k){
                    count++;
                }else{
                    break;
                }
            }
        }
        return count;
    }


}
