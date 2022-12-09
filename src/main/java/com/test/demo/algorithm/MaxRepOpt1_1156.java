package com.test.demo.algorithm;

/**
 * <p>
 * 1156. 单字符重复子串的最大长度
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 *
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 * 示例 1：
 *
 * 输入：text = "ababa"
 * 输出：3
 * </p>
 *
 * @author yangqingfang
 * @since 2022/12/8 14:45
 */
public class MaxRepOpt1_1156 {

    public static void main(String[] args) {
        MaxRepOpt1_1156 maxRepOpt1 = new MaxRepOpt1_1156();
        int ababa = maxRepOpt1.maxRepOpt1("ababa");
        System.out.println(ababa);

    }

    public int maxRepOpt1(String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }
        char[] chs = text.toCharArray();
        int[] cnt = new int[26];
        for (char c : chs) {
            cnt[c - 'a']++;
        }
        char currChar = chs[0];
        int currCharCnt = 1;
        int length = chs.length;
        int ans = 1;

        for (int i = 1; i < length; i++) {
            if (chs[i] == currChar) {
                currCharCnt++;
            } else {
                int idxSecond = i + 1;

                while (idxSecond < length && chs[idxSecond] == currChar) {
                    idxSecond++;
                    currCharCnt++;
                }

                if (cnt[currChar - 'a'] > currCharCnt) {
                    currCharCnt++;
                }

                ans = Math.max(ans, currCharCnt);

                currChar = chs[i];
                currCharCnt = 1;
            }
        }

        if (cnt[currChar - 'a'] > currCharCnt) {
            currCharCnt++;
        }

        ans = Math.max(ans, currCharCnt);

        return ans;
    }

}
