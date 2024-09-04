package com.example.demo.model;

public class StudentModel {
    private int ID;
    private String Name;
    private String MiddleName;
    private String LastName;
    private int Age;

    private boolean isDeleted;

    public StudentModel(int id, String name, String middleName, String lastName, int age, boolean isDeleted){
        ID = id;
        Name = name;
        MiddleName = middleName;
        LastName = lastName;
        Age = age;
        this.isDeleted = isDeleted;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
