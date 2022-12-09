package com.test.demo.algorithm;

/**
 * <p>
 * 1512. 好数对的数目
 * 给你一个整数数组 nums 。
 *
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 *
 * 返回好数对的数目。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * </p>
 *
 * @author yangqingfang
 * @since 2022/11/2 15:40
 */
public class NumIdenticalPairs_1512 {

    public static void main(String[] args) {
        NumIdenticalPairs_1512 numIdenticalPairs = new NumIdenticalPairs_1512();
        int[] nums = new int[]{1,2,3,1,1,3};
        System.out.println(numIdenticalPairs.numIdenticalPairs(nums));
    }

    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

}
