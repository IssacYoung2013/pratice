package com.issac.mvc.po;

import lombok.Data;

import java.util.Date;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-23
 * @desc:
 */
@Data
public class Item {
    private Integer id;

    private String name;

    private Float price;

    private String pic;

    private Date createtime;

    private String detail;
}
