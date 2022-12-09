package com.test.demo.algorithm;

/**
 * <p>
 * 1822. 数组元素积的符号
 * 已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
 *
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 *
 * 返回 signFunc(product) 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,-2,-3,-4,3,2,1]
 * 输出：1
 * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 * </p>
 *
 * @author yangqingfang
 * @since 2022/10/27 9:16
 */
public class ArraySign_1822 {

    public static void main(String[] args) {
        ArraySign_1822 arraySign = new ArraySign_1822();
        int[] nums = new int[]{100,100,-100,-99,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        System.out.println(arraySign.arraySign(nums));
    }

    public int arraySign(int[] nums) {
        int res = 1;
        for(int i=0;i<nums.length;i++){
            if((res * nums[i]) > 0){
                res = 1;
            }else if((res * nums[i]) < 0){
                res = -1;
            }else {
                return 0;
            }
        }
        if(res > 0){
            return 1;
        }
        return -1;
    }
}
