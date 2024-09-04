package com.example.demo.entity;

import com.example.demo.model.StudentModel;

public class StudentEntity extends StudentModel {

    public StudentEntity(int id, String name, String middleName, String lastName, int age, boolean isDeleted) {
        super(id, name,middleName, lastName, age, isDeleted);
    }
}
