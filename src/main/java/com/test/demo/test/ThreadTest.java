package com.test.demo.test;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/4/12 13:10
 */
public class ThreadTest {

    public static void main(String[] args) {
        try{

            System.out.println(Thread.currentThread()+":  第一个线程执行");

            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(5);
            executor.setMaxPoolSize(5);
            executor.setQueueCapacity(9999);
            executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
            executor.initialize();

            Thread thread = new Thread(() -> {
                int i = 4/0;
                System.out.println(Thread.currentThread() + ":  第二个线程执行");
            });

            executor.execute(thread);

            System.out.println(6666);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
