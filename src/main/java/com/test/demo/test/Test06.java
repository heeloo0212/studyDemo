package com.test.demo.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/7/18 17:24
 */
public class Test06 {

    public static void main(String[] args) {
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map1 = new HashMap<>();
        map1.put("id","123");
        map1.put("name","222");
        list.add(map1);
        Map<String,String> map2 = new HashMap<>();
        map2.put("id","123");
        map2.put("name","223");
        list.add(map2);
        Map<String,String> map3 = new HashMap<>();
        map3.put("id","124");
        map3.put("name","221");
        list.add(map3);
        Map<String,String> map5 = new HashMap<>();
        map5.put("id","125");
        map5.put("name","225");
        list.add(map5);
        Map<String, List<Map<String, String>>> id = list.stream().collect(Collectors.groupingBy(e -> e.get("id")));
        System.out.println(id);

        Map<Object,String> map6 = new HashMap<>();
        map6.put("456","456");
        System.out.println(map6.containsKey(456));
    }

}
