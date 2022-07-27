package com.test.demo.algorithm;

/**
 * @Describe: 464. 我能赢吗
 * @Author: yangqingfang
 * @Date: 2022/4/14 17:59
 */
public class CanIWin {
    public static void main(String[] args) {
        System.out.println(canIWinMethod(10,22));
    }

    public static boolean canIWinMethod(int maxChoosableInteger,int desiredTotal){
        if(maxChoosableInteger >= desiredTotal){
            return true;
        }
        if((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {return false;}

        return dfs(0, desiredTotal, new Boolean[1 << maxChoosableInteger], maxChoosableInteger);
    }

    private static boolean dfs(int state, int desiredTotal, Boolean[] dp, int maxChoosableInteger){
        if(dp[state] != null){
            return dp[state];
        }

        for(int i = 1; i <= maxChoosableInteger; i++){
            int cur = 1 << (i - 1);
            if((cur & state) != 0){
                continue;
            }

            if(i >= desiredTotal || !dfs(cur|state, desiredTotal - i, dp, maxChoosableInteger)){
                return dp[state] = true;
            }
        }
        return dp[state] = false;
    }

}

