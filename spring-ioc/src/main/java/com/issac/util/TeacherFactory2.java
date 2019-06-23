package com.issac.util;

import com.issac.beans.Teacher;

/**
 *
 *
 * @author: ywy
 * @date: 2019-06-08
 * @desc:
 */
public class TeacherFactory2 {
    
    public Teacher createTeacher() {
        Teacher teacher = new Teacher();
        teacher.setTname("Mr");
        System.out.println("TeacherFactory2 负责创建 teacher 类的实例对象");
        return teacher;
    }
}
