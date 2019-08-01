package com.issac.webflux.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

/**
 * @author: ywy
 * @date: 2019-07-16
 * @desc:
 */
@Data
// 指定在 mongodb 生成的表
@Document(collection = "t_student")
public class Student {

    @Id // 会生成表中设置id为主键
    private String id; // MongoDB 的主键一般为String类型

    @NotBlank(message = "姓名不能为空")
    private String name;

    @Range(min = 10, max = 50,message = "年龄必须在{min}-{max}范围")
    private int age;
}
