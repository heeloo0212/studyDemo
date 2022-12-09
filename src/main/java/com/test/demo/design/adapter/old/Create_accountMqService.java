package com.test.demo.design.adapter.old;

import com.alibaba.fastjson.JSON;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/9/5 14:18
 */
public class Create_accountMqService {

    public void onMessage(String message) {

        Create_account mq = JSON.parseObject(message, Create_account.class);

        mq.getNumber();
        mq.getAccountDate();

        // ... 处理自己的业务
    }
}
