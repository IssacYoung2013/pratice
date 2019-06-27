package com.issac.ssm.resolver;

import com.issac.ssm.exception.CustomException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-27
 * @desc:
 */
public class CustomExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        String message;

        // 异常逻辑
        if(ex instanceof CustomException) {
            message = ((CustomException)ex).getMsg();
        } else {
            message = "未知错误";
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");

        mv.addObject("message",message);

        return mv;
    }
}
