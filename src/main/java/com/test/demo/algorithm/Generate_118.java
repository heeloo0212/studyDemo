package com.test.demo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  杨辉三角
 * </p>
 *
 * @author yangqingfang
 * @since 2022/10/28 15:39
 */
public class Generate_118 {

    public static void main(String[] args) {
        Generate_118 generate = new Generate_118();
        List<List<Integer>> generate1 = generate.generate(5);
        for(List<Integer> list : generate1){
            list.forEach(i -> System.out.print(i+","));
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 1){
            res.add(Arrays.asList(new Integer[]{1}));
            return res;
        }
        res.add(Arrays.asList(new Integer[]{1}));
        res.add(Arrays.asList(new Integer[]{1,1}));
        if(numRows == 2){
            return res;
        }
        for(int i=2;i<numRows;i++){

            List<Integer> preRows = res.get(i - 1);
            List<Integer> rows = new ArrayList<>();
            for(int j=0;j<preRows.size();j++){
                if(j==0){
                    rows.add(1);
                }
                if(j+1<preRows.size()){
                    rows.add(preRows.get(j)+preRows.get(j+1));
                }
                if(j==preRows.size()-1){
                    rows.add(1);
                }
            }
            res.add(rows);
        }
        return res;
    }

}
