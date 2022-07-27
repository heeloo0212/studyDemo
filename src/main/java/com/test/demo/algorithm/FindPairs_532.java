package com.test.demo.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 532. 数组中的 k-diff 数对
 * </p>
 *
 * 给你一个整数数组nums 和一个整数k，请你在数组中找出 不同的k-diff 数对，并返回不同的 k-diff 数对 的数目。
 *
 * k-diff数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件：
 *
 * 0 <= i, j < nums.length
 * i != j
 * nums[i] - nums[j] == k
 * 注意，|val| 表示 val 的绝对值。
 *
 * @author yangqingfang
 * @since 2022/6/16 18:20
 */
public class FindPairs_532 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,4,1,5,3};
        System.out.println(findPairs(nums,2));
    }

    public static int findPairs(int[] nums, int k){
        int len = nums.length;
        Set<String> set = new HashSet<>();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(Math.abs(nums[i] - nums[j]) == k){
                    StringBuilder str = new StringBuilder();
                    str.append(nums[i]).append("-").append(nums[j]);
                    StringBuilder str2 = new StringBuilder();
                    str2.append(nums[j]).append("-").append(nums[i]);
                    if(!set.contains(str.toString()) && !set.contains(str2.toString())){
                        set.add(str.toString());
                    }

                }
            }
        }
        return set.size();
    }

    //官方题解
    public static  int findPairs2(int[] nums,int k){
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        for (int num : nums) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }

}
