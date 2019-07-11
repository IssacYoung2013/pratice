package com.issac.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: ywy
 * @date: 2019-07-09
 * @desc: 异步Servlet
 */
@WebServlet(value = "/async",asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();

        // 获取异步上下文，开启异步操作(完成异步线程之间通讯)
        AsyncContext asyncContext = request.startAsync();
        // 获取NIO的异步请求与响应
        ServletRequest asyncContextRequest = asyncContext.getRequest();
        ServletResponse asyncContextResponse = asyncContext.getResponse();

        // 异步执行耗时操作
        CompletableFuture.runAsync(()-> doSome(asyncContext,asyncContextRequest,asyncContextResponse));

        long endTime = System.currentTimeMillis();
        System.out.println("异步操作时 Web 服务器耗时（毫秒）：" + (endTime-startTime));
    }

    /**
     * 定义一个耗时操作
     * @param asyncContext
     * @param request
     * @param response
     */
    private void doSome(AsyncContext asyncContext, ServletRequest request, ServletResponse response) {
        try {
            TimeUnit.SECONDS.sleep(5);
            response.getWriter().println("Done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 耗时业务代码通知异步操作，任务完成
        asyncContext.complete();
    }
}
