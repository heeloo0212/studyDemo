package com.test.demo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 杨辉三角II
 * </p>
 *
 * @author yangqingfang
 * @since 2022/10/28 16:42
 */
public class GetRow_119 {

    public static void main(String[] args) {
        GetRow_119 getRow = new GetRow_119();
        List<Integer> row = getRow.getRow(10);
        row.forEach(i-> System.out.print(i+" "));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            if(i==0){
                row.add(1);
            }else {
                int left = 0;
                int right = 0;
                for (int j = 0; j < row.size(); j++) {
                    if(j==0){
                        row.set(0,1);
                    } else {
                        if(j == 1){
                            left = row.get(j-1);
                        }else {
                            left = right;
                        }
                        right = row.get(j);
                        row.set(j,left+right);
                    }
                    if(j==row.size()-1){
                        row.add(1);
                        break;
                    }

                }
            }
        }
        return row;
    }
}
