package com.issac.processor;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

/**
 * 消息处理器
 *
 * @author: ywy
 * @date: 2019-07-15
 * @desc:
 */
public class SomeProcessor extends SubmissionPublisher<String> implements Flow.Processor<Integer, String> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(10);
    }

    /**
     * 将大于50的消息过滤掉
     * 并将小于50的消息转换String
     *
     * @param item
     */
    @Override
    public void onNext(Integer item) {
        System.out.println("当前订阅者正在消费的数据为：" + item.toString());
        if (item < 50) {
            this.submit("该消息处理完毕：" + item.toString() );
        }
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.subscription.request(8);

        // 当满足某条件时，取消订阅
//        if(xxx) {
//            this.subscription.cancel();
//        }
    }

    /**
     * 当订阅过程中出现异常时会自动调用
     *
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
