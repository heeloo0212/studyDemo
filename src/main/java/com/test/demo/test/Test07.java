package com.test.demo.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/7/20 14:29
 */
public class Test07 {

    public static void main(String[] args) {
        BigDecimal v = new BigDecimal(25600);
        BigDecimal b = new BigDecimal(28000);
        BigDecimal divide = v.divide(b, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide);
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMaximumFractionDigits(2);
        String format = numberFormat.format(divide.doubleValue());
        System.out.println(format);

        System.out.println(new BigDecimal(25600).divide(b,2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)));
    }

}
