package com.mentorhints.springbootdemo.controller;

import com.mentorhints.springbootdemo.model.Student;
import com.mentorhints.springbootdemo.request.SubjectRequest;
import com.mentorhints.springbootdemo.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("/{studentId}")
    public String saveSubjects(@PathVariable String studentId,
                               @RequestBody List<SubjectRequest> subjectRequest) {
        return subjectService.saveSubject(subjectRequest, studentId);
    }

}
