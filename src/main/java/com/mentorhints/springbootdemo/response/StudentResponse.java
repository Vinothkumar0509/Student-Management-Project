package com.mentorhints.springbootdemo.response;

import com.mentorhints.springbootdemo.bean.Gender;
import com.mentorhints.springbootdemo.bean.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {
    private String id;
    private String name;
    private Integer age;
    private Gender gender;
    private String email;
    private String address;
    private String parentName;
    private StudentStatus studentStatus;

    private List<SubjectResponse> subjectResponse;
}
