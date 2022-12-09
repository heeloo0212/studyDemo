package com.test.demo.web.redisPubAndSub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/8/22 10:49
 */
@RestController
@RequestMapping("/redis")
public class RedisPubController {

    @Autowired
    private WebSocketServiceImpl webSocketService;

    @RequestMapping("/sendMsg")
    public void sendMsg(String msg){
        webSocketService.sendMessageAll(msg);
    }

}
