package com.example.demo.service;

import com.example.demo.model.StudentModel;
import com.example.demo.repository.InMemoryStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class inMemoryStudentServiceImpl implements StudentService{

    private final InMemoryStudentRepository studentRepository;

    public inMemoryStudentServiceImpl(InMemoryStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> findAllStudent() {
        return studentRepository.findAllStudents();
    }

    @Override
    public StudentModel findStudentById(int id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public StudentModel addStudent(StudentModel student) {
        return studentRepository.addStudent(student);
    }

    @Override
    public StudentModel updateStudent(StudentModel student) {
        return studentRepository.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }

    public void logicDeleteStudent(int id){
        studentRepository.logicDeleteStudent(id);
    }
    public void restoreAllDeletedStudents(){
        studentRepository.restoreAllDeletedStudents();
    }

    @Override
    public void deleteStudents(List<Integer> ids) {
        studentRepository.deleteStudents(ids);
    }

    @Override
    public void logicDeleteStudents(List<Integer> ids) {
        studentRepository.logicDeleteStudents(ids);
    }

    @Override
    public List<StudentModel> searchStudentsByName(String name) {
        return studentRepository.searchStudentsByName(name);
    }

    @Override
    public List<StudentModel> filterStudents(int filterType) {
        return studentRepository.filterStudents(filterType);
    }

}
