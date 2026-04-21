package com.mentorhints.springbootdemo;

import com.mentorhints.springbootdemo.Utils.StudentMapperUtils;
import com.mentorhints.springbootdemo.model.Student;
import com.mentorhints.springbootdemo.repository.StudentRepository;
import com.mentorhints.springbootdemo.response.StudentResponse;
import com.mentorhints.springbootdemo.service.StudentManagementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentManagementService studentManagementService;

    @Mock
    StudentMapperUtils studentMapperUtils;



    @Test()
    void test_WhetherItCanSaveStudent() {
        Student student = Student.builder()
                .id(UUID.randomUUID())
                .name("Arun")
                .build();
        Mockito.when(studentRepository.save(Mockito.any(Student.class))).thenReturn(student);
        String message  = studentManagementService.saveStudent(student);

        Assertions.assertEquals("Arun has been added successfully", message);
    }

    @Test
    void test_ItCanFetchAll() {
        Student student1 = Student.builder()
                .name("Arun")
                .id(UUID.randomUUID())
                .build();

        Student student2 = Student.builder()
                .name("Vinoth")
                .id(UUID.randomUUID())
                .build();

        StudentResponse studentResponse = StudentResponse.builder()
                .build();
        List<Student> students = new ArrayList<>();

        students.add(student1);
        students.add(student2);

        Mockito.when(studentRepository.findAll()).thenReturn(students);

//        Mockito.when(studentMapperUtils.mapToStudentResponse(student1)).thenReturn(studentResponse);

        List<StudentResponse> studentResponse1 = studentManagementService.getAllStudents();

        Assertions.assertEquals(2, studentResponse1.size());
    }



}