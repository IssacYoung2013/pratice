package com.issac.common;

import java.util.Random;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

/**
 *
 * 订阅测试类
 * @author: ywy
 * @date: 2019-07-12
 * @desc:
 */
public class SubscribeTest {
    public static void main(String[] args) {
        // 创建发布者
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        // 创建订阅者
        SomeSubscriber subscriber = new SomeSubscriber();
        // 建立订阅关系
        publisher.subscribe(subscriber);
        // 发布者生产并发送消息(生产300条消息)
        for (int i = 0; i < 300; i++) {
            // 产生随机整数
            int item = new Random().nextInt(100);
            System.out.println("生产出第"+ i + "条消息:" + item);
            // 发布消息，发布缓存满时submit()方法阻塞
            // 因为发布者不具有无限缓冲区
            publisher.submit(item);
        }
        // 关闭发布者
        publisher.close();

        // 为了防止消费消息
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
