package com.test.demo.algorithm;

/**
 * <p>
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库的sort函数的情况下解决这个问题。
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * </p>
 *
 * @author yangqingfang
 * @since 2022/11/3 16:15
 */
public class SortColors_75 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        SortColors_75 sortColors = new SortColors_75();
        sortColors.sortColors(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+",");
        }
    }

    public void sortColors(int[] nums) {
        int lastZeroIndex = 0;
        int lastOneIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0 && lastZeroIndex < nums.length){
                int temp = nums[i];
                nums[i] = nums[lastZeroIndex];
                nums[lastZeroIndex] = temp;
                lastZeroIndex++;
                if(lastOneIndex < lastZeroIndex){
                    lastOneIndex++;
                }
            }
            if(nums[i] == 1 && lastOneIndex <= i){
                int temp = nums[i];
                nums[i] = nums[lastOneIndex];
                nums[lastOneIndex] = temp;
                lastOneIndex++;
            }
        }
    }

}
