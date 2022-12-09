package com.test.demo.algorithm;

/**
 * <p>
 * 2139. 得到目标值的最少行动次数
 * 你正在玩一个整数游戏。从整数 1 开始，期望得到整数 target 。
 *
 * 在一次行动中，你可以做下述两种操作之一：
 *
 * 递增，将当前整数的值加 1（即， x = x + 1）。
 * 加倍，使当前整数的值翻倍（即，x = 2 * x）。
 * 在整个游戏过程中，你可以使用 递增 操作 任意 次数。但是只能使用 加倍 操作 至多 maxDoubles 次。
 *
 * 给你两个整数 target 和 maxDoubles ，返回从 1 开始得到 target 需要的最少行动次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 5, maxDoubles = 0
 * 输出：4
 * 解释：一直递增 1 直到得到 target 。
 * 示例 2：
 *
 * 输入：target = 19, maxDoubles = 2
 * 输出：7
 * 解释：最初，x = 1 。
 * 递增 3 次，x = 4 。
 * 加倍 1 次，x = 8 。
 * 递增 1 次，x = 9 。
 * 加倍 1 次，x = 18 。
 * 递增 1 次，x = 19 。
 * </p>
 *
 * @author yangqingfang
 * @since 2022/10/28 15:06
 */
public class MinMoves_2139 {

    public static void main(String[] args) {
        MinMoves_2139 minMoves = new MinMoves_2139();
        int i = minMoves.minMoves(999999996, 0);
        System.out.println(i);
    }

    //贪心算法
    public int minMoves(int target, int maxDoubles) {
        int res = 0;
        while (target > 1){
            if(maxDoubles == 0){
                res += target - 1;
                break;
            }
            if (target % 2 == 0) {
                target = target / 2;
                maxDoubles--;
            } else {
                target = target - 1;
            }
            res++;

        }
        return res;
    }

}
