package com.test.demo.web.redisPubAndSub;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 处理订阅redis的消息
 * @author
 */
@Component
public class RedisReceiver {


    /**
     * 处理消息
     *
     * @param message 消息队列中的消息
     */
    public void sendMsg(String message) {
        //SendSocketMsg msg = JSONObject.parseObject(message, SendSocketMsg.class);

        if(message != null) {
            // 处理广播消息
            System.out.println("接收到的消息："+message);
        }
    }

}