package com.test.demo.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @Describe: 380. O(1) 时间插入、删除和获取随机元素
 * @Author: yangqingfang
 * @Date: 2022/4/13 9:20
 */
public class RandomizedSetTest {

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }

}


class RandomizedSet {

    HashMap<Integer,Object> map = new HashMap<>();
    int flag = 0;

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val,val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            map.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int size = map.size();
        int i = new Random().nextInt(size);
        for(Map.Entry<Integer,Object> entry : map.entrySet()){
            if(flag == i){
                flag = 0;
                return entry.getKey();
            }
            flag += 1;
        }
        return 0;
    }
}
