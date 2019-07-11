package com.issac.service;

import com.issac.ssm.mapper.ItemMapper;
import com.issac.ssm.po.Item;
import com.issac.ssm.po.ItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ywy
 * @date: 2019-06-23
 * @desc:
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> queryItemList() {
        ItemExample example = new ItemExample();
//        ItemExample.Criteria criteria = example.createCriteria();
//        criteria.andIdEqualTo(1);
        List<Item> itemList = itemMapper.selectByExample(example);

        return itemList;
    }

    @Override
    public Item queryItemById(Integer id) {
        return id == null ? null : itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateItem(Item item) {
        if (item == null) {
            return;
        }
        if (item.getId() == null) {
            return;
        }
        itemMapper.updateByPrimaryKey(item);
    }
}
