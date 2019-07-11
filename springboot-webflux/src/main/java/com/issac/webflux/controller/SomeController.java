package com.issac.webflux.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: ywy
 * @date: 2019-07-08
 * @desc:
 */
@RestController
@Slf4j
public class SomeController {

    @RequestMapping("/common")
    public String commonHandle() {
        log.info("common--start");
        // 执行一个耗时操作
        String result = doSome("common handler");
        log.info("common--end");
        return result;
    }

    @RequestMapping("/mono")
    public Mono<String> monoHandle() {
        log.info("mono--start");
        // 执行一个耗时操作
        Mono<String> result = Mono.fromSupplier(() -> doSome("mono handler"));
        log.info("mono--end");
        // Mono 表示包含0或1个元素的异步序列
        return result;
    }

    @GetMapping("/flux")
    public Flux<String> fluxHandle() {
        // Flux 表示包含0或n个元素的异步序列
        return Flux.just("beijing", "shanghai", "hangzhou");
    }

    @GetMapping("/array")
    public Flux<String> fluxHandle(@RequestParam String[] cities) {
        // 将数组转换为Flux
        return Flux.fromArray(cities);
    }

    @GetMapping("/list")
    public Flux<String> fluxHandle(@RequestParam List<String> cities) {
        // 将List先转为Steam 再将Stream转换为Flux
        return Flux.fromStream(cities.stream());
    }

    @GetMapping("/time")
    public Flux<String> timeHandle(@RequestParam List<String> cities) {
        log.info("flux--start");

        // 将Flux的每个元素映射为一个doSome耗时操作
        Flux<String> result = Flux.fromStream(
                cities.stream().map(i -> doSome("element-" + i))
        );
        log.info("flux--end");

        return result;
    }

    @GetMapping(value = "/sse",produces = "test/event-stream")
    public Flux<String> sseHandle() {
        // Flux 表示包含0或n个元素的异步序列
        return Flux.just("beijing", "shanghai", "hangzhou");
    }

    /**
     * 定义耗时操作
     *
     * @param msg
     * @return
     */
    private String doSome(String msg) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return msg;
    }

}

