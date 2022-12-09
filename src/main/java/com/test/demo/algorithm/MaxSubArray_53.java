package com.test.demo.algorithm;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/10/24 10:53
 */
public class MaxSubArray_53 {

    public static void main(String[] args) {
        MaxSubArray_53 maxSubArray = new MaxSubArray_53();
        int[] nums = new int[]{5,4,-1,7,8};
        int i = maxSubArray.maxSubArray(nums);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(sum > 0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            res = Math.max(res,sum);
        }
        return res;
    }

}
