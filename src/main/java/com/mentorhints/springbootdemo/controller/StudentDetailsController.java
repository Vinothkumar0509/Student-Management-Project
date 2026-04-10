package com.mentorhints.springbootdemo.controller;

import com.mentorhints.springbootdemo.exception.StudentNotFoundException;
import com.mentorhints.springbootdemo.model.Student;
import com.mentorhints.springbootdemo.response.StudentResponse;
import com.mentorhints.springbootdemo.service.StudentManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student-management")
@RequiredArgsConstructor

public class StudentDetailsController {

    private final StudentManagementService studentManagementService;

    @GetMapping("/test")
    public String apiTesting() {
        return "Application server Started:Welcome to Spring Boot Demo";
    }

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student student) {
        return studentManagementService.saveStudent(student);
    }

    @GetMapping("/all")
    public List<Student> findAllStudents() {
        return studentManagementService.getAllStudents();
    }

    @GetMapping("/id/{id}")
    public StudentResponse findById(@PathVariable("id") String id) throws StudentNotFoundException {
        return studentManagementService.findByStudentId(id);
    }

    @GetMapping("/name/{name}")
    public StudentResponse findByName(@PathVariable("name") String name) throws StudentNotFoundException {
        return studentManagementService.findByStudentName(name);
    }
    //Mobile number update-> From old number to new
    @PutMapping ("/update")
    public StudentResponse updateStudent(@RequestParam(name = "studentId",required = true) String studentId,
                                         @RequestParam(name = "mobileNumber",required = true) String mobileNumber) {
        return studentManagementService.updateStudentNumber(studentId,mobileNumber);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable("id") String studentId) {
        return studentManagementService.deleteStudentById(studentId);
    }
}
