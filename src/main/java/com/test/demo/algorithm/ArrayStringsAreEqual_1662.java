package com.test.demo.algorithm;

/**
 * <p>
 * 1662. 检查两个字符串数组是否相等
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 *
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 tru
 * </p>
 *
 * @author yangqingfang
 * @since 2022/11/1 10:12
 */
public class ArrayStringsAreEqual_1662 {

    public static void main(String[] args) {
        ArrayStringsAreEqual_1662 arrayStringsAreEqual = new ArrayStringsAreEqual_1662();
        String[] word1 = new String[]{"ab", "c"};
        String[] word2 = new String[]{"a", "cb"};
        boolean b = arrayStringsAreEqual.arrayStringsAreEqual(word1, word2);
        System.out.println(b);
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer word1Buffer = new StringBuffer();
        StringBuffer word2Buffer = new StringBuffer();
        for(int i=0;i<word1.length;i++){
            word1Buffer.append(word1[i]);
        }
        for(int i=0;i<word2.length;i++){
            word2Buffer.append(word2[i]);
        }
        return word1Buffer.toString().equals(word2Buffer.toString());
    }

}
