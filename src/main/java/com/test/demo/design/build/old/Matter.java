package com.test.demo.design.build.old;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/9/5 10:24
 */
public interface Matter {

    String scene();      // 场景；地板、地砖、涂料、吊顶

    String brand();      // 品牌

    String model();      // 型号

    BigDecimal price();  // 价格

    String desc();       // 描述
}
