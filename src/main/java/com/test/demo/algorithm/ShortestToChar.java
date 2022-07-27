package com.test.demo.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/4/19 10:35
 */
public class ShortestToChar {

    public static void main(String[] args) {
        int[] ints = shortestToCharMethod("loveleetcode", 'e');
        for(int i=0;i<ints.length;i++){
            System.out.print(ints[i] + ",");
        }
        shortestToChar("loveleetcode", 'e');
    }

    public static int[] shortestToCharMethod(String s,char c){
        if(s.indexOf(c) < 0){
            return new int[s.length()];
        }
        int[] array = new int[s.length()];
        char[] charArray = s.toCharArray();
        List<Integer> charList = new ArrayList<>();
        for(int i=0;i<charArray.length;i++){
            if(charArray[i] == c){
                charList.add(i);
            }
        }
        System.out.println(charList);
        for(int i=0;i<charArray.length;i++){
            int m = Math.abs(charList.get(0) - i);
            for(int j=1;j<charList.size();j++){
                if(Math.abs(charList.get(j) - i) < m){
                    m = Math.abs(charList.get(j) - i);
                }
            }
            array[i] = m;
        }
        return array;
    }

    //官方题解
    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        //转换为数组[12,13,14,0,1,0,0,1,2,3,4,0]
        for (int i = 0, idx = -n; i < n; ++i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = i - idx;
        }
        //idx=24
        for (int i = n - 1, idx = 2 * n; i >= 0; --i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            //min(0,12-12),min(4,12-11),min(3,12-10),min(2,12-9),min(1,12-8),min(0,7-7),min(0,6-6),min(1,6-5),.....
            ans[i] = Math.min(ans[i], idx - i);
        }
        return ans;
    }

}
