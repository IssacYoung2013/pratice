package com.issac.util;

import com.issac.beans.Teacher;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: ywy
 * @date: 2019-06-08
 * @desc:
 */
public class TeacherFactory {

    /**
     * 节省内存消耗
     */
    public static Teacher createTeacher() {
        Teacher teacher = new Teacher();
        System.out.println("TeacherFactory 负责创建 teacher 类的实例对象");
        return teacher;
    }

    BeanPostProcessor cc;
}
