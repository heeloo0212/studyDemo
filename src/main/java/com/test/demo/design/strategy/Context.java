package com.test.demo.design.strategy;

import java.math.BigDecimal;

/**
 * <p>
 * 策略控制类
 * </p>
 *
 * @author yangqingfang
 * @since 2022/9/5 10:07
 */
public class Context<T> {

    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }

}
