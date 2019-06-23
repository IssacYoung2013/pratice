package com.issac.mapper;

import org.apache.ibatis.annotations.Param;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-22
 * @desc:
 */
public interface UserMapper {

    /**
     * 修改账户金额
     * @param id
     * @param money
     */
    void update(@Param("id") Integer id, @Param("money") double money);

    /**
     * 查询账户金额
     * @param id
     * @return
     */
    double queryMoney(Integer id);
}
