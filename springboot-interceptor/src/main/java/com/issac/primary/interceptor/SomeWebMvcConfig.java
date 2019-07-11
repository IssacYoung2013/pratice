package com.issac.primary.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author: ywy
 * @date: 2019-07-05
 * @desc:
 */
@Configuration //表示当前类为CodeConfig 类，即充当Spring容器
public class SomeWebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        SomeInterceptor someInterceptor = new SomeInterceptor();
        registry.addInterceptor(someInterceptor)
                .addPathPatterns("/first/**") // 拦截first开头的请求
                .excludePathPatterns("/first/aaa"); // 不拦截 second 开头的请求
        super.addInterceptors(registry);
    }
}
