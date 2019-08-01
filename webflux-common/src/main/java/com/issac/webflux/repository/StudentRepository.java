package com.issac.webflux.repository;

import com.issac.webflux.bean.Student;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 *
 *
 * @author: ywy
 * @date: 2019-07-16
 * @desc: 第一个泛型是该Repository操作的对象类型
 * 第二个泛型为操作对象主键类型
 */
public interface StudentRepository extends ReactiveMongoRepository<Student,String> {

    /**
     * 根据年龄上下限查询
     * @param below 年龄下限
     * @param top 年龄上限
     * @return
     */
    Flux<Student> findByAgeBetween(int below, int top);

    /**
     * 使用 MongoDB 原始查询实现根据年龄上下限查询
     * @param below
     * @param top
     * @return
     */
    @Query("{age: {$gte : ?0,$lte:?1}}")
    Flux<Student> queryByAge(int below, int top);
}
