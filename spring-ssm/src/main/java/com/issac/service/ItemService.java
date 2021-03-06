package com.issac.service;

import com.issac.ssm.po.Item;

import java.util.List;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-23
 * @desc:
 */
public interface ItemService {

    List<Item> queryItemList();

    Item queryItemById(Integer id);

    void updateItem(Item item);
}
