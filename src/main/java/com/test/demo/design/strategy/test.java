package com.test.demo.design.strategy;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/9/5 10:08
 */
public class test{

    public static void main(String[] args) {

        test_mj();
        test_nyg();
        test_zk();

    }

    public static void test_mj() {
        // 满100减10，商品100元
        Context<Map<String,String>> context = new Context<Map<String,String>>(new MJCouponDiscount());
        Map<String,String> mapReq = new HashMap<String, String>();
        mapReq.put("x","100");
        mapReq.put("n","10");
        BigDecimal discountAmount = context.discountAmount(mapReq, new BigDecimal(100));
        System.out.println("测试结果：满减优惠后金额" + discountAmount);
    }

    public static void test_zk() {
        // 折扣9折，商品100元
        Context<Double> context = new Context<Double>(new ZKCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(0.9D, new BigDecimal(100));
        System.out.println("测试结果：折扣9折后金额 {}" + discountAmount);
    }

    public static void test_nyg() {
        // n元购；100-10，商品100元
        Context<Double> context = new Context<Double>(new NYGCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(90D, new BigDecimal(100));
        System.out.println("测试结果：n元购优惠后金额 {}" + discountAmount);
    }

}
