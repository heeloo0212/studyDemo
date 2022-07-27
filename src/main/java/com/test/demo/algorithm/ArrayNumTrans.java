package com.test.demo.algorithm;

import java.util.*;

/**
 * @Describe: 1331. 数组序号转换
 * @Author: yangqingfang
 * @Date: 2022/4/7 13:13
 */
public class ArrayNumTrans {

    public static void main(String[] args) {
        int[] array = new int[]{37,12,28,9,100,56,9,5,12};
        int[] ints = ArrayNumTransMethod(array);
        for(int i=0;i<ints.length;i++){
            System.out.print(ints[i]+" ");
        }
    }

    public static int[] ArrayNumTransMethod(int[] array){
        int length = array.length;
        int[] temp = array.clone();
        Arrays.sort(array);
        Map<Integer,Integer> map = new HashMap<>();
        int flag = 1;
        for(int i=0;i<array.length;i++){

            if(!map.containsKey(array[i])) {
                map.put(array[i], flag);
                flag ++;
            }
        }
        for(int i=0;i<length;i++){
            array[i] = map.get(temp[i]);
        }
        return array;
    }

}
