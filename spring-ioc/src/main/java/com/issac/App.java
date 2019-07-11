package com.issac;

import com.issac.service.BaseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext factory = new ClassPathXmlApplicationContext("spring_config.xml");
//        Student student = (Student) factory.getBean("student");
//        System.out.println(student.getSname() +" " + student.getAge() + " " + student.getTeacher());
//        Teacher teacher = (Teacher)factory.getBean("teacher");
//        System.out.println(teacher.getTeacherName());
//        System.out.println(teacher.getFriendArray());
//        System.out.println(teacher.getSchool());

//        BaseService service = (BaseService) factory.getBean("isomeService");
//        System.out.println(service.doSome());

        BaseService personProxy = (BaseService) factory.getBean("personProxy");
        personProxy.eat();
        personProxy.wc();
    }
}
