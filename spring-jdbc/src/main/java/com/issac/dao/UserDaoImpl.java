package com.issac.dao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: ywy
 * @date: 2019-06-21
 * @desc: JdbcDaoSupport 内部封装了 JdbcTemplate
 */
@Repository
@Data
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    // JDBC 操作
    // Mybatis 操作
    // JdbcTemplate 操作

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @Override
    public void update(Integer id, double money) {
       this.getJdbcTemplate().update("UPDATE USER SET money = " + money + " WHERE id = " + id);
    }

    @Override
    public double query(Integer id) {
        Double money = (Double) this.getJdbcTemplate().queryForObject("select money from user where id = ?",
                new DoubleMapper(), id);
        return money;
    }
}


class DoubleMapper implements RowMapper {
    @Override
    public Double mapRow(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getDouble("money");
    }
}