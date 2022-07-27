package com.test.demo.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 731. 我的日程安排表 II
 * </p>
 *
 * @author yangqingfang
 * @since 2022/7/19 16:34
 */
public class MyCalendarTwo_731 {

    public static List<Integer> first = new ArrayList<>();

    public static Map<String,String> second = new HashMap<>();

    public MyCalendarTwo_731() {

    }

    public static void main(String[] args) {
        System.out.println(book(26,35));
        System.out.println(book(26,32));
        System.out.println(book(25,32));
        System.out.println(book(18,26));
        System.out.println(book(40,45));
        System.out.println(book(19,26));
        System.out.println(book(48,50));
        System.out.println(book(1,6));
        System.out.println(book(46,50));
        System.out.println(book(11,18));
//        System.out.println(book(10,20));
//        System.out.println(book(50,60));
//        System.out.println(book(10,40));
//        System.out.println(book(5,15));
//        System.out.println(book(5,10));
//        System.out.println(book(25,55));
    }

    public static boolean book(int start, int end) {
            if(end < start){
                return false;
            }
            for(String key : second.keySet()){
                String value = second.get(key);
                String[] splitArr = value.split("-");
                int i = Integer.valueOf(splitArr[0]);
                int j = Integer.valueOf(splitArr[1]);
                if(start <= i && end > i){
                    return false;
                }
                if(start < j && end > j){
                    return false;
                }
            }
            if(first.size() == 2){
                int te = first.get(0);
                int tr = first.get(1);
                if (start <= te && end > te) {
                    String key = start + "-" + end;
                    String value = te + "-" + end;
                    second.put(key, value);
                }
                if (start < tr && end > tr) {
                    String key = start + "-" + end;
                    String value = start + "-" + tr;
                    second.put(key, value);
                }
            }else {
                for (int i = 0; i < first.size() - 2; ) {
                    int te = first.get(i);
                    int tr = first.get(i + 1);
                    if (start <= te && end > te) {
                        String key = start + "-" + end;
                        String value = te + "-" + end;
                        second.put(key, value);
                    }
                    if (start < tr && end > tr) {
                        String key = start + "-" + end;
                        String value = start + "-" + tr;
                        second.put(key, value);
                    }
                    i = i + 2;
                }
            }
            first.add(start);
            first.add(end);
        System.out.println(first);
        System.out.println(second);
            return true;
    }


}
