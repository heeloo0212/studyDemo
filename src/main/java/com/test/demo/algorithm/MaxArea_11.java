package com.test.demo.algorithm;

/**
 * <p>
 * 11. 盛最多水的容器
 * </p>
 *
 * @author yangqingfang
 * @since 2022/11/2 10:46
 */
public class MaxArea_11 {

    public static void main(String[] args) {
        MaxArea_11 maxArea = new MaxArea_11();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea.maxArea(height));
    }

    public int maxArea(int[] height) {
        int len = height.length;
        int maxArea = 0;
        for(int i=0;i<len;i++){
            if(maxArea > height[i] * (len-i)){
                continue;
            }
            for(int j=i+1;j<len;j++){
                int min = Math.min(height[i],height[j]);
                int area = min * (j - i);
                maxArea = Math.max(maxArea,area);
            }
        }
        return maxArea;
    }

}
