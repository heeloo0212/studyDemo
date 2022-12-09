package com.test.demo.algorithm;

/**
 * <p>
 * 754. 到达终点数字
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 *
 * 你可以做一些数量的移动 numMoves :
 *
 * 每次你可以选择向左或向右移动。
 * 第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
 * 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
 *
 * 示例 1:
 *
 * 输入: target = 2
 * 输出: 3
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 -1 。
 * 第三次移动，从 -1 到 2 。
 * </p>
 *
 * @author yangqingfang
 * @since 2022/11/4 9:10
 */
public class ReachNumber_754 {

    public static void main(String[] args) {
        ReachNumber_754 reachNumber = new ReachNumber_754();
        int i = reachNumber.reachNumber(2);
        System.out.println(i);
    }

    public int reachNumber(int target) {
        int t=Math.abs(target);
        int s=0;
        int dis=0;
        //dis = 1+2+3+4+```+s
        while(dis<t){
            s++;
            dis+=s;

        }
        int dt=dis-t;
        if(dt%2==0)
            return s;
        else{
            if(s%2==0)
                return s+1;
            else
                return s+2;
        }
    }


}
