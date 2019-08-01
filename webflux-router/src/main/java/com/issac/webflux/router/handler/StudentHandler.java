package com.issac.webflux.router.handler;

import com.issac.webflux.router.bean.Student;
import com.issac.webflux.router.repository.StudentRepository;
import com.issac.webflux.router.util.NameValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author: ywy
 * @date: 2019-07-27
 * @desc: 流编程惰性编程，中间方法，直至遇到终止方法
 */
@Component
public class StudentHandler {

    @Autowired
    StudentRepository repository;

    /**
     * 查询
     *
     * @param request
     * @return
     */
    public Mono<ServerResponse> findAllHandle(ServerRequest request) {
        return ServerResponse
                // 指定响应码（返回BodyBuilder的方法称为响应体设置中间方法）
                .ok()
                // 指定响应体中的内容类型
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                //
                .body(repository.findAll(), Student.class)
                ;
    }

    /**
     * 添加
     */
    public Mono<ServerResponse> saveHandle(ServerRequest request) {

        // 从请求中获取要添加的数据，并将其封装为指定类型的对象，存放在Mono流中
        Mono<Student> studentMono = request.bodyToMono(Student.class);
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(repository.saveAll(studentMono), Student.class);
    }

    /**
     * 添加: 对name的合法性验证
     */
    public Mono<ServerResponse> saveHandleValidate(ServerRequest request) {

        // 从请求中获取要添加的数据，并将其封装为指定类型的对象，存放在Mono流中
        Mono<Student> studentMono = request.bodyToMono(Student.class);

        return studentMono
                .flatMap(stu -> {
                    // 对Name进行合法性验证
                    NameValidateUtil.validateName(stu.getName());

                    return ServerResponse
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .body(repository.saveAll(studentMono), Student.class);
                });
    }

    /**
     * 删除 根据id删除，删除成功返回200，没有找到返回404
     */
    public Mono<ServerResponse> delHandle(ServerRequest request) {

        // 从请求路径中获取id
        String id = request.pathVariable("id");
        return repository
                .findById(id)
                .flatMap(stu -> repository.delete(stu)
                        .then(ServerResponse.ok().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
        // Mono的defaultIfEmpty与switchIfEmpty方法对比
        // 1）defaultIfEmpty 中的参数是 Mono 中的值，若其调用者（Mono）中没有任何元素，则会将此方法
        // 中的参数作为该调用者Mono中的元素，调用者Mono与返回值Mono是同一个对象
        // 2）switchIfEmpty 中的参数是一个 Mono，若其调用者Mono中没有任何元素，则直接将参数Mono
        // 作为返回值，摒弃了原来调用者Mono，即调用者Mono与返回值Mono不是同一个对象
    }

    /**
     * 修改
     */
    public Mono<ServerResponse> updateHandle(ServerRequest request) {
        // 从请求路径中获取id
        String id = request.pathVariable("id");
        // 从请求中获取要添加的数据，并将其封装为指定类型的对象，存放在Mono流中
        Mono<Student> studentMono = request.bodyToMono(Student.class);

        return studentMono
                .flatMap(stu -> {
                    // 验证姓名的合法性
                    NameValidateUtil.validateName(stu.getName());
                    stu.setId(id);
                    return ServerResponse
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .body(repository.save(stu), Student.class);
                });
    }

}
