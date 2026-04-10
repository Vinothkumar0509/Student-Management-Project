package com.mentorhints.springbootdemo.model;


import com.mentorhints.springbootdemo.bean.Gender;
import com.mentorhints.springbootdemo.bean.StudentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private Integer age;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private String email;
    private String address;
    private String parentName;
    private String mobileNo;
    @Enumerated(value = EnumType.STRING)
    private StudentStatus studentStatus;

    // mapping is done but we need to tell this to hibernate so we are using this
    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)

    private List<Subject> subjects;//this is for java


//    public Student(StudentStatus studentStatus, String mobileNo, String parentName, String email, Gender gender, String address, Integer age, String name) {
//        this.studentStatus = studentStatus;
//        this.mobileNo = mobileNo;
//        this.parentName = parentName;
//        this.email = email;
//        this.gender = gender;
//        this.address = address;
//        this.age = age;
//        this.name = name;
//    }
//
//    public Student() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public Gender getGender() {
//        return gender;
//    }
//
//    public void setGender(Gender gender) {
//        this.gender = gender;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getParentName() {
//        return parentName;
//    }
//
//    public void setParentName(String parentName) {
//        this.parentName = parentName;
//    }
//
//    public String getMobileNo() {
//        return mobileNo;
//    }
//
//    public void setMobileNo(String mobileNo) {
//        this.mobileNo = mobileNo;
//    }
//
//
//    public StudentStatus getStudentStatus() {
//        return studentStatus;
//    }
//
//    public void setStudentStatus(StudentStatus studentStatus) {
//        this.studentStatus = studentStatus;
//    }
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", gender=" + gender +
//                ", email='" + email + '\'' +
//                ", address='" + address + '\'' +
//                ", parentName='" + parentName + '\'' +
//                ", mobileNo='" + mobileNo + '\'' +
//                ", studentStatus=" + studentStatus +
//                '}';
//    }
}
