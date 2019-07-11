package com.issac.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author: ywy
 * @date: 2019-07-09
 * @desc: 同步Servlet
 */
@WebServlet("/sync")
public class SyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();
        doSome(request, response);
        long endTime = System.currentTimeMillis();
        System.out.println("同步操作时 Web 服务器耗时：" + (endTime-startTime));
    }

    /**
     * 定义一个耗时操作
     * @param request
     * @param response
     */
    private void doSome(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        response.getWriter().println("Done!");
    }
}
