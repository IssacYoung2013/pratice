package com.issac.util;

import lombok.Setter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-12
 * @desc:
 */
@Setter
public class MyPointCut implements Pointcut {

    /**
     * InvocationHandler接口
     *  invoke() {
     *      if(obj.getClass != Person.class) {
     *          return
     *      }
     *      if(!methodObj.getName.equals("eat")) {
     *          return;
     *      }
     *      // 织入方式：次要业务方法和Person.eat执行顺序
     *      // 前置通知
     *      wash();
     *      Person.eat();
     *
     *  }
     */
    // 使用依赖注入
    private ClassFilter classFilter;

    private MethodMatcher methodMatcher;

    @Override
    public ClassFilter getClassFilter() {
        return this.classFilter;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this.methodMatcher;
    }
}
