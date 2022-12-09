package com.test.demo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/10/24 8:51
 */
public class PartitionDisjoint_915 {

    public static void main(String[] args) {
        PartitionDisjoint_915 _915 = new PartitionDisjoint_915();
        int[] nums = new int[]{1,15,1,0,6,12,4,2,3,16,17,13};
        int i = _915.partitionDisjoint(nums);
        System.out.println(i);
    }

    List<Integer> array = new ArrayList<>();

    public int partitionDisjoint(int[] nums) {
        for(int i=0;i< nums.length;i++){
            int max = getMaxNum(nums[i]);
            boolean flag = true;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] < max){
                    flag = false;
                    break;
                }
            }
            if(flag) return i+1;
        }
        return 0;
    }

    public int getMaxNum(int num){
        array.add(num);
        return array.stream().reduce(array.get(0),Integer::max);
    }

}
