package com.imodeng.model;

import lombok.Data;

@Data
public class Student {

    private String name;
    private String cls;
    private String country;

    public Student(String name, String cls, String country) {
        this.name = name;
        this.cls = cls;
        this.country = country;
    }
}
