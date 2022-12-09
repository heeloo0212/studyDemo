package com.test.demo.algorithm;

/**
 * <p>
 * 2243. 计算字符串的数字和
 * 给你一个由若干数字（0 - 9）组成的字符串 s ，和一个整数。
 *
 * 如果 s 的长度大于 k ，则可以执行一轮操作。在一轮操作中，需要完成以下工作：
 *
 * 将 s 拆分 成长度为 k 的若干 连续数字组 ，使得前 k 个字符都分在第一组，接下来的 k 个字符都分在第二组，依此类推。注意，最后一个数字组的长度可以小于 k 。
 * 用表示每个数字组中所有数字之和的字符串来 替换 对应的数字组。例如，"346" 会替换为 "13" ，因为 3 + 4 + 6 = 13 。
 * 合并 所有组以形成一个新字符串。如果新字符串的长度大于 k 则重复第一步。
 * 返回在完成所有轮操作后的 s 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "11111222223", k = 3
 * 输出："135"
 * 解释：
 * - 第一轮，将 s 分成："111"、"112"、"222" 和 "23" 。
 *   接着，计算每一组的数字和：1 + 1 + 1 = 3、1 + 1 + 2 = 4、2 + 2 + 2 = 6 和 2 + 3 = 5 。
 *   这样，s 在第一轮之后变成 "3" + "4" + "6" + "5" = "3465" 。
 * - 第二轮，将 s 分成："346" 和 "5" 。
 *   接着，计算每一组的数字和：3 + 4 + 6 = 13 、5 = 5 。
 *   这样，s 在第二轮之后变成 "13" + "5" = "135" 。
 * 现在，s.length <= k ，所以返回 "135" 作为答案
 * </p>
 *
 * @author yangqingfang
 * @since 2022/10/27 11:44
 */
public class DigitSum_2243 {

    public static void main(String[] args) {
        String s = "233";
        DigitSum_2243 digitSum = new DigitSum_2243();
        String s1 = digitSum.digitSum(s, 3);
        System.out.println(s1);
    }

    public String digitSum(String s, int k) {
        if(s.length() <= k){
            return s;
        }
        char[] array = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        int sum = 0;
        for(int i=0;i<array.length;i++){
            if(i%k == 0 && i!=0){
                sb.append(sum);
                sum = 0;
            }
            sum +=  Character.getNumericValue(array[i]);
        }
        sb.append(sum);
        if(sb.length() > k){
            return digitSum(sb.toString(),k);
        }else {
            return sb.toString();
        }
    }
}
