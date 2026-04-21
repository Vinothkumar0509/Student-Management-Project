package com.mentorhints.springbootdemo.service;

import com.mentorhints.springbootdemo.Utils.StudentMapperUtils;
import com.mentorhints.springbootdemo.Utils.SubjectMapperUtils;
import com.mentorhints.springbootdemo.exception.StudentNotFoundException;
import com.mentorhints.springbootdemo.model.Student;
import com.mentorhints.springbootdemo.model.Subject;
import com.mentorhints.springbootdemo.repository.StudentRepository;
import com.mentorhints.springbootdemo.repository.SubjectRepository;
import com.mentorhints.springbootdemo.response.StudentResponse;
import com.mentorhints.springbootdemo.response.SubjectResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentManagementService {
//    Logger log = LoggerFactory.getLogger(StudentManagementService.class);

    private final StudentMapperUtils studentMapperUtils;
    private final StudentRepository studentRepository;
    private final SubjectMapperUtils subjectMapperUtils;

    List<Student> studentList = new ArrayList<>();


    public String saveStudent(Student student) {
        Student studentModel = studentRepository.save(student);
        return studentModel.getName() + " has been added successfully";
    }

    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();
//        return students;
        return students.stream()
                .map(studentMapperUtils::mapToStudentResponse)
                .toList();
    }

    public StudentResponse findByStudentId(String id) {
        Student student = studentRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new StudentNotFoundException("Student with id: " + id + " not found"));

        List<SubjectResponse> subjectResponse = student.getSubjects().stream()
                .map(sub -> subjectMapperUtils.mapToSubjectResponse(sub))
                .toList();

        return studentMapperUtils.mapToStudentResponse(student, subjectResponse);
    }

    public StudentResponse findByStudentName(String name) {
        Student student = studentRepository.findByName(name)
                .orElseThrow(() -> new StudentNotFoundException("Student with name: " + name + " not found"));
        return studentMapperUtils.mapToStudentResponse(student);
    }


    public StudentResponse updateStudentNumber(String studentId, String mobileNumber) {
        log.info("Updating student number for student id " + studentId + " mobile number " + mobileNumber);
        Student student = studentRepository.findById(UUID.fromString(studentId))
                .orElseThrow(() -> new StudentNotFoundException("Student with id: " + studentId + " not found"));
        student.setMobileNo(mobileNumber);
        studentRepository.save(student);


        return studentMapperUtils.mapToStudentResponse(student);// Send Notification to this new number

        //return student.getMobileNo()+ "saved successfully";
    }

    public String deleteStudentById(String studentId) {
        log.info("Deleting student id " + studentId);
        try {
            studentRepository.deleteById(UUID.fromString(studentId));
        } catch (Exception e) {
            throw e;
        }

        return studentId + "Deleted Successfully";
    }
}
