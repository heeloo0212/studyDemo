package com.test.demo.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 *  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author yangqingfang
 * @since 2022/6/16 19:01
 */
public class IsValid_20 {

    public static void main(String[] args) {
        String s = "}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s){
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(Character c : chars){
            if(map.containsKey(c) && !stack.empty()){
                Character peek = stack.peek();
                if(map.get(c).equals(peek))
                    stack.pop();
                else
                    stack.push(c);
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
