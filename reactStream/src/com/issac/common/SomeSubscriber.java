package com.issac.common;

import java.util.concurrent.Flow;

/**
 * @author: ywy
 * @date: 2019-07-11
 * @desc:
 */
public class SomeSubscriber implements Flow.Subscriber {

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
    public void onNext(Object item) {
        System.out.println("当前订阅者正在消费的数据为：" + item.toString());
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
