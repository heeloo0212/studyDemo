package com.test.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Describe: 824. 山羊拉丁文824. 山羊拉丁文
 * @Author: yangqingfang
 * @Date: 2022/4/21 17:28
 */
public class ToGoatLatin {

    public static void main(String[] args) {
        String str = "I speak Goat Latin";
        System.out.println(toGoatLatinMethod(str));
    }

    public static String toGoatLatinMethod(String sentence){
        Map<Character,Character> mapChar = new HashMap<>(8);
        mapChar.put('a','a');
        mapChar.put('e','e');
        mapChar.put('i','i');
        mapChar.put('o','o');
        mapChar.put('u','u');
        mapChar.put('A','A');
        mapChar.put('E','E');
        mapChar.put('I','I');
        mapChar.put('O','O');
        mapChar.put('U','U');
        String[] s = sentence.split(" ");
        StringBuilder resultSb = new StringBuilder();
        StringBuilder aSb = new StringBuilder();
        for(int i=0;i<s.length;i++){
            StringBuilder sb = new StringBuilder(s[i]);
            if(mapChar.containsKey(sb.charAt(0))){
                sb.append("ma");
            }else{
                String head = sb.substring(0,1);
                String suffix = sb.substring(1,sb.length());
                StringBuilder suffixSb = new StringBuilder(suffix);
                sb = suffixSb.append(head).append("ma");
            }
            aSb.append("a");
            resultSb.append(sb).append(aSb).append(" ");

        }
        return resultSb.toString().substring(0,resultSb.length()-1);
    }
}
