package com.test.demo.test;

import com.alibaba.fastjson.JSONObject;
import com.test.demo.web.redisPubAndSub.SendSocketMsg;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/7/20 14:29
 */
public class Test07 {

    public static void main(String[] args) throws Exception{
        Long id = System.currentTimeMillis();
        System.out.println(id);
        Long t = id>>10;
        int i = Long.hashCode(t);
        System.out.println(i);
        System.out.println(t);

    }

}
