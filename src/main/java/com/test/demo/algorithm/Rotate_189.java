package com.test.demo.algorithm;

/**
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 */
public class Rotate_189 {

    public static void main(String[] args) {
        int[] nums = {1,2};
        rotate(nums,3);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }

    public static void rotate(int[] nums, int k){
        k = k % nums.length;
        reserve(0,nums.length-k-1,nums);
        reserve(nums.length-k,nums.length-1,nums);
        reserve(0,nums.length-1,nums);
    }

    public static void reserve(int start,int end,int[] nums){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
