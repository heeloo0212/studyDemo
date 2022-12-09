package com.test.demo.algorithm;

/**
 * <p>
 * 1668. 最大重复子字符串
 * 给你一个字符串 sequence ，如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，那么单词 word 的 重复值为 k 。单词 word 的 最大重复值 是单词 word 在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
 *
 * 给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：sequence = "ababc", word = "ab"
 * 输出：2
 * 解释："abab" 是 "ababc" 的子字符串。
 * </p>
 *
 * @author yangqingfang
 * @since 2022/10/31 14:23
 */
public class MaxRepeating_1668 {

    public static void main(String[] args) {
        MaxRepeating_1668 maxRepeating = new MaxRepeating_1668();
        String s = "ababc";
        String str = "ab";
        int i = maxRepeating.maxRepeating(s, str);
        int i1 = maxRepeating.maxRepeating2(s, str);
        System.out.println(i);
        System.out.println(i1);
    }

    public int maxRepeating(String sequence, String word) {
        char[] array = sequence.toCharArray();
        char[] sonArray = word.toCharArray();
        int count = 0;
        int times = 0;
        int max = 0;
        int len = sonArray.length;
        int index = 0;
        for(int j=0;j<array.length;j++){
            if(array[j] == sonArray[times]){
                times++;
                if(times == len){
                    times = 0;
                    count++;
                    index = j-len+1;
                }
            }else {
                j = index;
                index++;

                count = 0;
                times=0;
            }
            max = Math.max(max,count);
        }
        return max;
    }


    public int maxRepeating2(String sequence, String word) {
        int count=0;
        String tmp=word;
        while(sequence.contains(word)){
            word+=tmp;
            count++;
        }
        return count;
    }

}
