package com.test.demo.algorithm;

/**
 * @Describe: 868. 二进制间距
 * @Author: yangqingfang
 * @Date: 2022/4/27 14:51
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 *
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 *
 * 示例 1：
 *
 * 输入：n = 22
 * 输出：2
 * 解释：22 的二进制是 "10110" 。
 * 在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
 * 第一对相邻的 1 中，两个 1 之间的距离为 2 。
 * 第二对相邻的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 */
public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(binaryGapMethod(78));
    }

    public static int binaryGapMethod(int n) {
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        char[] chars = s.toCharArray();
        int max = 0;
        int ans = 0;
        for(int i=0;i<chars.length;i++){
            if(chars[i] == '1'){
                if(ans > max){
                    max = ans;
                }
                ans = 0;
            }
            ans ++;
        }
        return max;
    }

    //官方
    public int binaryGap(int n) {
        int last = -1, ans = 0;
        for (int i = 0; n != 0; ++i) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        return ans;
    }

}
