package com.issac.primary.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: ywy
 * @date: 2019-07-02
 * @desc:
 */
@Component
@PropertySource(value = "classpath:custom.properties",encoding = "UTF-8")
@Data
@ConfigurationProperties("student")
public class StudentDto {

    private String name;
    private int age;
    private double score;
}
