package com.test.demo.test.springEvent;

import com.test.demo.test.springEvent.BaseUserEventer;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/5/6 8:45
 */
@Component
public class EventListen {

    @EventListener
    public void ListenEvent(BaseUserEventer event){
        System.out.println("监听到了event事件"+event);
    }

}
