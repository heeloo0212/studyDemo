package com.test.demo.web.redisPubAndSub;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/8/22 10:47
 */
@Service
public class WebSocketServiceImpl {

    @Resource
    RedisTemplate<String,String> redisTemplate;

    public void sendMessageAll(String socketMsg) {
        System.out.println("发送的消息:"+socketMsg);
        redisTemplate.convertAndSend("test-msg-topic", socketMsg);
    }

    public void sendMessageById(SendSocketMsg socketMsg) {
        redisTemplate.convertAndSend("ws-device-msg-topic",JSON.toJSONString(socketMsg));
    }

}
