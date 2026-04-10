package com.mentorhints.springbootdemo.service;

import com.mentorhints.springbootdemo.Utils.SubjectMapperUtils;
import com.mentorhints.springbootdemo.model.Student;
import com.mentorhints.springbootdemo.model.Subject;
import com.mentorhints.springbootdemo.repository.StudentRepository;
import com.mentorhints.springbootdemo.repository.SubjectRepository;
import com.mentorhints.springbootdemo.request.SubjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final SubjectMapperUtils subjectMapperUtils;

    public String saveSubject(List<SubjectRequest> subjectRequest, String studentId) {
        UUID id = UUID.fromString(studentId);
        Optional<Student> student = studentRepository.findById(id);

        List<Subject> subjectList = new ArrayList();

        if (student.isPresent()) {
            for (SubjectRequest sub : subjectRequest) {
                Subject subject = subjectMapperUtils.mapToSubject(sub);
                subject.setStudent(student.get());
                subjectList.add(subject);
            }

            subjectRepository.saveAll(subjectList);
            return "Subjects saved for student id " + studentId;
        }
        return "Student with id " + id + " not found";
    }

}
