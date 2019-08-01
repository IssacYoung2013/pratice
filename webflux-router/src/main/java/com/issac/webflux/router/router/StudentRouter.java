package com.issac.webflux.router.router;

import com.issac.webflux.router.handler.StudentHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author: ywy
 * @date: 2019-07-27
 * @desc: @Configuration 表示该类为CodeConfig类，其充当Spring容器
 */
@Configuration
public class StudentRouter {

    @Bean
    public RouterFunction<ServerResponse> customRouter(StudentHandler handler) {
        return RouterFunctions
                .nest(RequestPredicates.path("/student"),
                        RouterFunctions.route(RequestPredicates.GET("/all"), handler::findAllHandle)
//                                .andRoute(RequestPredicates.POST("/save")
//                                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)),
//                                        handler::saveHandle)
                                .andRoute(RequestPredicates.POST("/save")
                                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)),
                                        handler::saveHandleValidate)
                                .andRoute(RequestPredicates.DELETE("/del/{id}"),
                                        handler::delHandle)
                                .andRoute(RequestPredicates.PUT("/update/{id}"),
                                        handler::updateHandle)
                );
    }
}
