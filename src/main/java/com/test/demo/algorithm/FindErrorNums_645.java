package com.test.demo.algorithm;

import java.util.Arrays;

/**
 * <p>
 * 645. 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * </p>
 *
 * @author yangqingfang
 * @since 2022/12/6 11:19
 */
public class FindErrorNums_645 {

    public static void main(String[] args) {
        FindErrorNums_645 findErrorNums = new FindErrorNums_645();
        int[] nums = new int[]{2,2};
        int[] errorNums = findErrorNums.findErrorNums(nums);
        for(int i=0;i<errorNums.length;i++){
            System.out.println(errorNums[i]+",");
        }
    }

    public int[] findErrorNums(int[] nums) {
        int sum = 0;
        int trueSum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        for(int i=1;i<nums.length+1;i++){
            trueSum += i;
        }
        Arrays.sort(nums);
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            if(i+1 < nums.length){
                if(nums[i] == nums[i+1]){
                    res[0] = nums[i];
                    res[1] = nums[i] + (trueSum - sum);
                }
            }
        }
        return res;
    }

}
