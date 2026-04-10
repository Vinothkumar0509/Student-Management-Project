package com.mentorhints.springbootdemo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SubjectResponse {

    private String subjectId;
    private String subjectName;

//    public StudentResponse mapToStudentResponse(Student student, List<SubjectResponse> subjects) {
//        return student.builder()
//                .id(UUID.fromString(student.getId().toString()))
//                .name(student.getName())
//                .age(student.getAge())
//                .email(student.getEmail())
//                .gender(student.getAge())
//                .address(student.getAddress())
//                .studentStatus(student.getStudentStatus())
//                .parentName(student.getParentName())
//                .subjects(student.getSubjects())
//                .build();


}
