package com.example.demo.controller;

import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {


    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.findAllStudent());
        return "StudentList";
    }

    @PostMapping("/students/add")
    public String addStudent(@RequestParam String name,
                             @RequestParam String middleName,
                             @RequestParam String lastName,
                             @RequestParam int age,
                             @RequestParam(defaultValue = "false")  boolean isDeleted
    ) {

        StudentModel newStudent = new StudentModel(0, name,middleName, lastName, age, isDeleted);
        studentService.addStudent(newStudent);
        return "redirect:/students";
    }

    @PostMapping("/students/update")
    public String updateStudent(@RequestParam int id,
                                @RequestParam String name,
                                @RequestParam String middleName,
                                @RequestParam String lastName,
                                @RequestParam int age,
                                @RequestParam(defaultValue = "false")  boolean isDeleted) {
        StudentModel updatedStudent = new StudentModel(id, name,middleName, lastName, age, isDeleted);
        studentService.updateStudent(updatedStudent);
        return "redirect:/students";
    }

    @PostMapping("/students/delete")
    public String deleteStudent(@RequestParam int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    private List<Integer> idents = new ArrayList<>();
    @PostMapping("students/logic_delete")
    public String logicDeleteStudent(@RequestParam int id){
        idents.add(id);
        studentService.logicDeleteStudent(id);
        return "redirect:/students";
    }

    @PostMapping("students/deletes")
    public String deleteStudents(@RequestParam List<Integer> ids){
        if (idents != null) {
            studentService.deleteStudents(ids);
            idents = null;
        }
        studentService.deleteStudents(ids);
        return "redirect:/students";
    }

    @PostMapping("students/logic_deletes")
    public String logicDeleteStudents(@RequestParam("ids") List<Integer> ids){

        studentService.logicDeleteStudents(ids);
        return "redirect:/students";
    }

    @PostMapping("students/search")
    public String searchStudentsByName(Model model, @RequestParam String name){
        model.addAttribute("students", studentService.searchStudentsByName(name));
        return "StudentList";
    }

    @PostMapping("students/filter")
    public String filterStudents(Model model, @RequestParam int filterType){
        model.addAttribute("students", studentService.filterStudents(filterType));
        return "StudentList";
    }

    @PostMapping("students/restore")
    public String restoreAllDeletedStudents(Model model){
        studentService.restoreAllDeletedStudents();
        return "redirect:/students";
    }

}
