package com.test.demo.design.build.buildPattern;

import com.test.demo.design.build.old.Matter;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/9/5 10:57
 */
public interface IMenu {

    IMenu appendCeiling(Matter matter); // 吊顶

    IMenu appendCoat(Matter matter);    // 涂料

    IMenu appendFloor(Matter matter);   // 地板

    IMenu appendTile(Matter matter);    // 地砖

    String getDetail();                 // 明细
}
