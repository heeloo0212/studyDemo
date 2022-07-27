package com.test.demo.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Describe: 388. 文件的最长绝对路径
 * @Author: yangqingfang
 * @Date: 2022/4/20 8:36
 */
public class LengthLongestPath {

    public static void main(String[] args) {
        String str = "dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext";
        String str2 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        int i = lengthLongestPath(str2);
        System.out.println(i);
    }

    public static int lengthLongestPathMethod(String input){
        if(input.indexOf(".") < 0){
            return 0;
        }
        //去除后面为空目录的文件夹
        String[] split = input.split("\n");
        int flag = 0;

        List<StringBuilder>  sbList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(split[0]);
        for(int i=1;i<split.length;i++){

        }

        return 0;
    }

    public static int lengthLongestPath(String input) {
        int n = input.length();
        int pos = 0;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();

        while (pos < n) {
            /* 检测当前文件的深度 */
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }
            System.out.println("depth: "+depth + "  pos: "+pos);
            /* 统计当前文件名的长度 */
            boolean isFile = false;
            int len = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }
            System.out.println("len: "+len + "  pos: "+pos);
            /* 跳过当前的换行符 */
            pos++;

            while (stack.size() >= depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                len += stack.peek() + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                stack.push(len);
            }
        }
        return ans;

    }

}
