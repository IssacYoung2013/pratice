package com.issac.processor;

import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;

/**
 * @author: ywy
 * @date: 2019-07-11
 * @desc:
 */
public class SomeSubscriber implements Flow.Subscriber<String> {

    /**
     * 声明订阅令牌
     */
    private Flow.Subscription subscription;

    /**
     * 当发布者第一次发布消息时，会自动调用该方法
     *
     * @param subscription
     */
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        // 设置订阅者首次向发布者（通过令牌）订阅消息的数量
        this.subscription.request(10);
    }

    /**
     * 订阅者每接收一次消息数据，自动调用一次该方法
     * 订阅者对数据的消费就发生在这里
     *
     * @param item
     */
    @Override
    public void onNext(String item) {
        System.out.println("当前订阅者正在消费的数据为：" + item.toString());
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 设置订阅者向发布者再次订阅消息的数量，即每消费一条消息
        // 则再向发布者订阅多条消息
        this.subscription.request(10);

        // 当满足某条件时，取消订阅
//        if(xxx) {
//            this.subscription.cancel();
//        }
    }

    /**
     * 当订阅过程中出现异常时会自动调用
     * @param throwable
     */
    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        this.subscription.cancel();
    }

    /**
     * 当令牌中所有的消息全部消费完毕会自动调用该方法
     */
    @Override
    public void onComplete() {
        System.out.println("所有消息消费完毕！");
    }
}
