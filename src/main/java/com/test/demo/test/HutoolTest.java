package com.test.demo.test;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/6/14 10:06
 */
public class HutoolTest {

    public static void main(String[] args) {
//        Date startDate = new Date();
//        System.out.println(startDate);
//        DateTime dateTime = DateUtil.offsetMonth(startDate, -1);
//        System.out.println(dateTime);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM") ;
//        String date = "2022-06";
//        String s = format.format(date);
//        System.out.println(s);
//        int year = DateUtil.year(new Date());
//        System.out.println(year);
//        System.out.println(LocalDateTime.now().getYear());
        System.out.println(DateUtil.format(DateUtil.date(),"yyyy-MM-dd hh:mm:ss")+"----"+DateUtil.format(DateUtil.tomorrow(),"yyyy-MM-dd hh:mm:ss"));

        Date parse = DateUtil.parse("2022-03-18 00:00:00", "yyyy-MM-dd HH:mm:ss");
        System.out.println(parse);

    }

}
