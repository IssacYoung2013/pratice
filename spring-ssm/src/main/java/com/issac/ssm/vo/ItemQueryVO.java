package com.issac.ssm.vo;

import com.issac.ssm.po.Item;
import lombok.Data;

import java.util.List;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-26
 * @desc:
 */
@Data
public class ItemQueryVO {

    private Item item;

    private List<Item> itemList;
}
