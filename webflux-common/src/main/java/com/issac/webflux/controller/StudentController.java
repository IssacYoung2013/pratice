package com.issac.webflux.controller;

import com.issac.webflux.bean.Student;
import com.issac.webflux.repository.StudentRepository;
import com.issac.webflux.util.NameValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author: ywy
 * @date: 2019-07-16
 * @desc:
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    /**
     * 正常返回，一次性返回数据
     *
     * @return
     */
    @GetMapping("/all")
    public Flux<Student> getAll() {
        return repository.findAll();
    }

    /**
     * 以sse形式，实时性返回数据
     *
     * @return
     */
    @GetMapping(value = "/sse/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> getSseAll() {
        return repository.findAll();
    }

    /**
     * 添加数据
     *
     * @param student
     * @return
     */
    @PostMapping("/save")
    public Mono<Student> saveStudent(@Valid Student student) {
        // 验证姓名的合法性
        NameValidateUtil.validateName(student.getName());
        return repository.save(student);
    }

    /**
     * 添加数据
     *
     * @param student
     * @return
     */
    @PostMapping("/save2")
    public Mono<Student> saveStudent2(@Valid @RequestBody Student student) {
        // 验证姓名的合法性
        NameValidateUtil.validateName(student.getName());
        return repository.save(student);
    }

    /**
     * 无状态删除
     */
    @DeleteMapping("/delcomm/{id}")
    public Mono<Void> deleteStudent(@PathVariable("id") String id) {
        return repository.deleteById(id);
    }

    /**
     * 有状态删除:删除对象存在则删除成功，则返回响应码200，否则返回响应码404
     * ResponseEntity 封装响应体中的数据即响应码
     * Mono的 map 与 flatMap 方法均可用于做元素映射，选择的标准是，一般情况下映射过程中需要
     * 再执行一些操作的过程，需要选择使用flatMap；若仅仅是元素的映射，而无需执行一些操作，则选择map
     * 若一个方法没有返回值，但又需要让其具有返回值，则可为其添加then方法，该方法的返回值将作为
     * 这个方法的返回值
     * defaultIfEmpty() 执行的条件是，其Mono中若没有元素，则执行。
     */
    @DeleteMapping("/del/{id}")
    public Mono<ResponseEntity<Void>> deleteStatusStudent(@PathVariable("id") String id) {

        return repository.findById(id)
                .flatMap(stu -> repository.delete(stu)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * 修改操作：若修改成功，则返回修改对象数据及200；若指定的id对象不存在，则返回404
     * save 可以完成插入与修改操作，执行不同操作的判别标准是：其参数对象的id是否为null
     * 若id为null则执行插入操作
     * 若id不为null则执行修改操作
     */
    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<Student>> updateStudent(@PathVariable("id") String id,
                                                       @Valid @RequestBody Student student) {
        // 验证姓名的合法性
        NameValidateUtil.validateName(student.getName());
        return repository.findById(id)
                .flatMap(stu -> {
                    stu.setAge(student.getAge());
                    stu.setName(student.getName());
                    return repository.save(stu);
                })
                .map(stu -> new ResponseEntity<>(stu, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    /**
     * 根据id查询 若查询成功，则返回200；若指定的id对象不存在，则返回404
     */
    @GetMapping("/find/{id}")
    public Mono<ResponseEntity<Student>> findById(@PathVariable("id") String id) {
        return repository.findById(id)
                .map(stu -> new ResponseEntity<>(stu, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * 根据年龄的上下限进行查询 --- 一次性返回
     */
    @GetMapping("/age/{below}/{top}")
    public Flux<Student> findStudentByAge(@PathVariable("below") int below,
                                          @PathVariable("top") int top) {
        return repository.findByAgeBetween(below, top);
    }

    /**
     * 根据年龄的上下限进行查询 --- sse返回
     */
    @GetMapping(value = "/sse/age/{below}/{top}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> findStudentByAgeSSE(@PathVariable("below") int below,
                                          @PathVariable("top") int top) {
        return repository.findByAgeBetween(below, top);
    }

    /**
     * 根据年龄的上下限进行查询 --- 一次性返回
     */
    @GetMapping("/query/age/{below}/{top}")
    public Flux<Student> findStudentByQueryAge(@PathVariable("below") int below,
                                          @PathVariable("top") int top) {
        return repository.queryByAge(below, top);
    }

    /**
     * 根据年龄的上下限进行查询 --- sse返回
     */
    @GetMapping(value = "/sse/query/age/{below}/{top}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Student> findStudentByQueryAgeSSE(@PathVariable("below") int below,
                                             @PathVariable("top") int top) {
        return repository.queryByAge(below, top);
    }
}
