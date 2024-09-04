package com.example.demo.service;

import com.example.demo.model.StudentModel;

import java.util.List;


public interface StudentService {
    public List<StudentModel> findAllStudent();
    public StudentModel findStudentById(int id);
    public StudentModel addStudent(StudentModel student);
    public StudentModel updateStudent(StudentModel student);
    public void deleteStudent(int id);
    public void logicDeleteStudent(int id);

    public void restoreAllDeletedStudents();

    public void deleteStudents(List<Integer> ids);
    public void logicDeleteStudents(List<Integer> ids);

    public List<StudentModel> searchStudentsByName(String name);
    public List<StudentModel> filterStudents(int filterType);



}
