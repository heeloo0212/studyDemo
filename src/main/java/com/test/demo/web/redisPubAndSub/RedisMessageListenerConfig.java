package com.test.demo.web.redisPubAndSub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @author
 */
@Configuration
public class RedisMessageListenerConfig {
    @Autowired
    private RedisReceiver redisReceiver;

    /**
     * 监听redis中的订阅信息
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisMessageListenerContainer getRedisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        // 添加redis消息队列监听，监听im-topic消息主题的消息，使用messageListenerAdapter()中设置的类和方法处理消息。
        redisMessageListenerContainer.addMessageListener(messageAllListenerAdapter(), new PatternTopic("test-msg-topic"));
        return redisMessageListenerContainer;
    }

    /**
     * 添加订阅消息处理类，通过反射获取处理类中的处理方法
     * 即使用RedisReceiver类中的sendMsg方法处理消息
     * @return
     */
    @Bean
    public MessageListenerAdapter messageAllListenerAdapter() {
        return new MessageListenerAdapter(redisReceiver, "sendMsg");
    }
}