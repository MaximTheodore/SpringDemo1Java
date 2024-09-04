package com.example.demo.repository;

import com.example.demo.model.StudentModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class InMemoryStudentRepository {


    private final List<StudentModel> STUDENTS = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public StudentModel addStudent(StudentModel student) {
        student.setID(idCounter.getAndIncrement());
        STUDENTS.add(student);
        return student;
    }

    public StudentModel updateStudent(StudentModel student) {
        int studentIndex = IntStream.range(0, STUDENTS.size())
                .filter(index -> STUDENTS.get(index).getID() == student.getID())
                .findFirst()
                .orElse(-1);

        return studentIndex == -1 ? null : STUDENTS.set(studentIndex, student);
    }

    public List<StudentModel> findAllStudents(){
        return STUDENTS.stream()
                .filter(studentModel -> !studentModel.isDeleted())
                .collect(Collectors.toList());
    }

    public StudentModel findStudentById(int id){
        return STUDENTS.stream()
                .filter(studentModel -> studentModel.getID() == id)
                .findFirst()
                .orElse(null);
    }

    public void deleteStudent(int id){
        var student = findStudentById(id);
        if (student != null) {
            STUDENTS.remove(student);
        }
    }

    public void logicDeleteStudent(int id){
        var student = findStudentById(id);
        if (student != null) {
            student.setDeleted(true);
        }
    }

    //множественное физ удаление
    public void deleteStudents(List<Integer> ids) {
        STUDENTS.removeIf(student -> ids.contains(student.getID()));
    }

    //множественное логич удаление
    public void logicDeleteStudents(List<Integer> ids) {
        STUDENTS.stream()
                .filter(student -> ids.contains(student.getID()))
                .forEach(student -> student.setDeleted(true));
    }

    public void restoreAllDeletedStudents() {
        STUDENTS.stream()
                .filter(StudentModel::isDeleted)
                .forEach(student -> student.setDeleted(false));
    }

    public List<StudentModel> searchStudentsByName(String name) {
        return STUDENTS.stream()
                .filter(student -> !student.isDeleted() && student.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<StudentModel> filterStudents(int filterType) {
        return STUDENTS.stream()
                .filter(student -> !student.isDeleted())
                .filter(student -> {
                    if (filterType == 1) {
                        return student.getAge() >= 16 && student.getAge() <= 18;
                    } else if (filterType == 2) {
                        return student.getLastName().startsWith("А") || student.getLastName().startsWith("A");
                    } else if (filterType == 3) {
                        return student.getName().startsWith("А") || student.getName().startsWith("A");
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }






}
