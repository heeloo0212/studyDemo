package com.test.demo.algorithm;

/**
 * @Describe:  796. 旋转字符串
 * @Author: yangqingfang
 * @Date: 2022/4/7 10:45
 */
public class RotateString {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String s = "abcdefg";
        String goal = "efgabcd";
        //System.out.println(rotateStringMethod(s,goal));
        System.out.println(rotateStringMethod2(s,goal));
        long time = System.currentTimeMillis() - startTime;
        System.out.println("耗时："+ time);
    }

    public static Boolean rotateStringMethod(String s,String goal){
        if(s==null || goal==null){
            return false;
        }
        if(s.length() != goal.length()){
            return false;
        }
        int flag = s.length();
        while (true) {
            if (s.equals(goal)) {
                return true;
            }
            //旋转字符串
            String firstStr = s.substring(0, 1);
            String endStr = s.substring(1);
            s = endStr + firstStr;
            if(flag == 0){
                return false;
            }
            flag --;
        }

    }

    //官方题解优化
    public static Boolean rotateStringMethod2(String s,String goal){
        return s.length()==goal.length() && (s+s).contains(goal);
    }
}
