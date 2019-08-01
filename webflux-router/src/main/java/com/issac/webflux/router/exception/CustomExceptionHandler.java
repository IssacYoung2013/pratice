package com.issac.webflux.router.exception;

import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

/**
 * @author: ywy
 * @date: 2019-07-30
 * @desc: 自定义异常处理器:当异常发生时返回400，并返回异常信息
 */
@Component
// 默认情况下，系统内部定义的异常处理器的优先级要高于自定义异常处理器，可通过@Order指定优先级级别
// 指定的优先级越小，优先级越高，支持负数
@Order(-99)
public class CustomExceptionHandler implements WebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        // 获取http 响应对象
        ServerHttpResponse response = serverWebExchange.getResponse();
        // 设置响应码400
        response.setStatusCode(HttpStatus.NOT_FOUND);
        // 设置响应类型普通文本
        response.getHeaders().setContentType(MediaType.TEXT_PLAIN);
        // 获取异常信息
        String message = this.formatExceptionMessage(throwable);
        DataBuffer buffer = response.bufferFactory().wrap(message.getBytes());
        return response.writeWith(Mono.just(buffer));
    }

    private String formatExceptionMessage(Throwable ex) {
        String msg = "发生异常：" + ex.getMessage();
        if (ex instanceof StudentException) {
            StudentException exception = (StudentException) ex;
            msg += "【" + exception.getErrValue() + exception.getErrField() + "】";
        }
        return msg;
    }
}
