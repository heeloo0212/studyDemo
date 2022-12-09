package com.test.demo.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/8/31 14:21
 */
public class ValidateStackSequences_946 {

    public static void main(String[] args) {
        boolean b = validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
        System.out.println(b);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped){
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int n = pushed.length;
        for (int i = 0, j = 0; i < n; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();

    }

}
