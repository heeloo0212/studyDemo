package com.test.demo.algorithm;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/11/4 15:14
 */
public class Maximum69Number_1323 {

    public static void main(String[] args) {
        Maximum69Number_1323 maximum69Number = new Maximum69Number_1323();
        int res = maximum69Number.maximum69Number(9699 );
        System.out.println(res);
    }

    public int maximum69Number (int num) {
        int div = 10000;
        int res = 0;
        while (div != 0){
            if(num / div != 0){
                if(num / div == 6){
                    res += 9 * div + (num % div);
                    break;
                }
                res += (num / div) * div;
                num = num % div;
            }
            div = div / 10;
        }
        return res;
    }

}
