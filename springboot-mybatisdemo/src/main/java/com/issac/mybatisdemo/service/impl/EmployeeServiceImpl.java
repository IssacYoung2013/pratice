package com.issac.mybatisdemo.service.impl;

import com.issac.mybatisdemo.dao.EmployeeDao;
import com.issac.mybatisdemo.po.Employee;
import com.issac.mybatisdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author: ywy
 * @date: 2019-07-03
 * @desc:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao dao;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    //    @Transactional
    @CacheEvict(value = "realTimeCache", allEntries = true)
    @Override
    public void addEmployee(Employee employee) {
        dao.insertEmployee(employee);
//        int i = 3 / 0;
//        dao.insertEmployee(employee);
    }

    @Cacheable(value = "realTimeCache", key = "'employee_'+#id")
    @Override
    public Employee findEmployeeById(int id) {
        return dao.selectEmployeeById(id);
    }

    // 使用双重检测锁解决热点缓存问题
    @Override
    public int findEmployeeCount() {
//        获取redis操作对象
        BoundValueOperations<Object, Object> ops = redisTemplate.boundValueOps("count");
        // 从缓存中读取数据
        Object count = ops.get();
        if (count == null) {
            synchronized (this) {
                count = ops.get();
                if (count == null) {
                    // 从DB中查询
                    count = dao.selectEmployeeCount();
                    // 将查询的数据写入到 redis 缓存，并设置到期时限
                    ops.set(count,10, TimeUnit.SECONDS);
                }
            }
        }
        return (int) count;
    }
}
