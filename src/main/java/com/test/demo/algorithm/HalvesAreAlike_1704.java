package com.test.demo.algorithm;

import java.util.HashMap;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/11/11 9:44
 */
public class HalvesAreAlike_1704 {

    public static void main(String[] args) {
        HalvesAreAlike_1704 areAlike = new HalvesAreAlike_1704();
        System.out.println(areAlike.halvesAreAlike("textbook"));
    }

    public boolean halvesAreAlike(String s) {
        HashMap<Character,Character> map = new HashMap(16);
        map.put('a','a');
        map.put('e','e');
        map.put('i','i');
        map.put('o','o');
        map.put('u','u');
        map.put('A','A');
        map.put('E','E');
        map.put('I','I');
        map.put('O','O');
        map.put('U','U');
        int start = 0;
        int end = s.length()-1;
        int aNum = 0;
        int bNum = 0;
        char[] charArray = s.toCharArray();
        while (true){
            if(map.containsKey(charArray[start])){
                aNum++;
            }
            if(map.containsKey(charArray[end])){
                bNum++;
            }
            start++;
            if(start == end){
                break;
            }else {
                end--;
            }
        }
        return aNum == bNum;
    }
}
