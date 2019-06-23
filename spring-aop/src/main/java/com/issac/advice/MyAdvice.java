package com.issac.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 编写通知类
 *
 * @author: ywy
 * @date: 2019-06-18
 * @desc:
 */
public class MyAdvice {
    /**
     * 演示前置通知
     */
    public void log() {
        System.out.println("记录日志");
    }

    /**
     * 演示后置通知
     */
    public void log2() {
        System.out.println("记录日志222");
    }

    /**
     * 演示最终通知
     */
    public void log3() {
        System.out.println("记录日志333");
    }

    /**
     * 演示异常抛出通知
     */
    public void log4() {
        System.out.println("记录日志444");
    }

    /**
     * 环绕通知
     * 场景使用：事务管理
     *
     * @param joinPoint
     */
    public void log5(ProceedingJoinPoint joinPoint) {
        System.out.println("环绕通知前");
        // 调用目标对象的方法
        try {
            joinPoint.proceed();
            System.out.println("环绕通知后");

        } catch (Throwable throwable) {
            System.out.println("异常出现了");
        } finally {
            System.out.println("最终通知");
        }
    }

}
