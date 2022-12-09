package com.test.demo.algorithm;

/**
 * <p>
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
 * </p>
 *
 * @author yangqingfang
 * @since 2022/11/9 10:01
 */
public class LengthOfLongestSubstring_3 {

    public static void main(String[] args) {
        String str = "a ";
        LengthOfLongestSubstring_3 length = new LengthOfLongestSubstring_3();
        System.out.println(length.lengthOfLongestSubstring(str));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int res = 0;
        StringBuffer sb = new StringBuffer();
        int remIndex = 0;
        for(int i=0;i<arr.length;i++){
            String item = String.valueOf(arr[i]);
            if(sb.indexOf(item) == -1){
                sb.append(item);
                if(sb.length() == 1){
                    remIndex = i;
                }
            }else {
                sb = new StringBuffer();
                i = remIndex;
            }
            res = Math.max(res,sb.length());
        }
        return res;
    }
}
