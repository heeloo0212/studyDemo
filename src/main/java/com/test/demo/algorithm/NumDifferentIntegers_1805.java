package com.test.demo.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 *
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 *
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 *
 * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 * </p>
 *
 * @author yangqingfang
 * @since 2022/12/6 10:18
 */
public class NumDifferentIntegers_1805 {

    public static void main(String[] args) {
        NumDifferentIntegers_1805 numDifferentIntegers = new NumDifferentIntegers_1805();
        int test = numDifferentIntegers.numDifferentIntegers("167278959591294");
        System.out.println(test);
    }

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        char[] arr = word.toCharArray();
        int start = 0;
        int strLen = 0;
        for(int i=0;i< arr.length;i++){
            char c = arr[i];
            if(c>=48 && c<=57){
                if(start == 0 && strLen == 0) {
                    start = i;
                }
                strLen++;
            }else{
                while(true){
                    if(arr[start] == 48 && strLen > 1){
                        start ++;
                        strLen --;
                    }else{
                        break;
                    }
                }

                if(strLen > 0) {
                    set.add(word.substring(start, start + strLen));
                }
                start = 0;
                strLen = 0;
            }
        }
        if(strLen > 0){
            while(true){
                if(arr[start] == 48 && strLen > 1){
                    start ++;
                    strLen --;
                }else{
                    break;
                }
            }
            set.add(word.substring(start, start + strLen));
        }
        return set.size();
    }

}
