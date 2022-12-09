package com.test.demo.algorithm;

/**
 * <p>
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * </p>
 *
 * @author yangqingfang
 * @since 2022/11/10 15:47
 */
public class FindMedianSortedArrays_4 {

    public static void main(String[] args) {
        FindMedianSortedArrays_4 arrays = new FindMedianSortedArrays_4();
        int[] nums1 = new int[]{2,4};
        int[] nums2 = new int[]{1,3};
        double medianSortedArrays = arrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] resNum = new int[m+n];
        int mIndex = 0;
        int nIndex = 0;
        for(int i=0;i<m+n;i++){
            if(mIndex == m){
                resNum[i] = nums2[nIndex];
                nIndex++;
                continue;
            }
            if(nIndex == n){
                resNum[i] = nums1[mIndex];
                mIndex++;
                continue;
            }
            if(nums1[mIndex] <= nums2[nIndex]){
                resNum[i] = nums1[mIndex];
                mIndex++;
            }else{
                resNum[i] = nums2[nIndex];
                nIndex++;
            }
        }
        double res;
        int mid = (m+n)/2;
        if((m+n) % 2 == 0){
            res = ((double)resNum[mid] + (double)resNum[mid-1]) / 2;
        }else{
            res = resNum[mid];
        }
        return res;
    }

}
