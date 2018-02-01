package com.ws.wstest;

import io.spring.guides.gs_producing_web_service.Student;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class StudentRepository {

    private static final Map<String, Student> students = new HashMap<>();

    @PostConstruct
    public void initData() {

        Student me = new Student();
        me.setAddress("Guatemala");
        me.setAge(30);
        me.setName("Luisdany Pernillo");

        students.put(me.getName(), me);

    }

    public Student findStudent(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return students.get(name);
    }

}
