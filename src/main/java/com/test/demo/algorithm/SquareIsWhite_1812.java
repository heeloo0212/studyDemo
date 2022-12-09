package com.test.demo.algorithm;

/**
 * <p>
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 * </p>
 *
 * @author yangqingfang
 * @since 2022/12/8 10:01
 */
public class SquareIsWhite_1812 {

    public static void main(String[] args) {
        SquareIsWhite_1812 squareIsWhite = new SquareIsWhite_1812();
        System.out.println(squareIsWhite.squareIsWhite("h3"));

    }

    public boolean squareIsWhite(String coordinates) {
        boolean[] arr = new boolean[]{false,true,false,true,false,true,false,true};
        char zm = coordinates.charAt(0);
        int num = Integer.parseInt(coordinates.substring(1));
        return (zm-'a')%2==0?arr[num-1]:!arr[num-1];
    }

}
