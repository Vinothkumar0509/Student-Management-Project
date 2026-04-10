package com.mentorhints.springbootdemo.Utils;

import com.mentorhints.springbootdemo.model.Student;
import com.mentorhints.springbootdemo.response.StudentResponse;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperUtils {

    public StudentResponse mapToStudentResponse(Student student) {

        return StudentResponse.builder()
                .id(student.getId().toString())
                .name(student.getName())
                .age(student.getAge())
                .email(student.getEmail())
                .gender(student.getGender())
                .address(student.getAddress())
                .studentStatus(student.getStudentStatus())
                .parentName(student.getParentName())
                .build();
//        StudentResponse studentResponse = new StudentResponse();
//        studentResponse.setId(student.getId());
//        studentResponse.setName(student.getName());
//        studentResponse.setAge(student.getAge());
//        studentResponse.setAddress(student.getAddress());
//        studentResponse.setEmail(student.getEmail());
//        studentResponse.setGender(student.getGender());
//        studentResponse.setStudentStatus(student.getStudentStatus());
//        studentResponse.setParentName(student.getParentName());
//        return studentResponse;
    }
}
