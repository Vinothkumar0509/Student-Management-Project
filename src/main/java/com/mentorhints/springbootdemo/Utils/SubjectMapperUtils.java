package com.mentorhints.springbootdemo.Utils;

import com.mentorhints.springbootdemo.model.Subject;
import com.mentorhints.springbootdemo.request.SubjectRequest;
import com.mentorhints.springbootdemo.response.SubjectResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.mentorhints.springbootdemo.response.SubjectResponse.*;

@Component
public class SubjectMapperUtils {

    public Subject mapToSubject(SubjectRequest subjectrequest){
        return Subject.builder()
                .subjectName(subjectrequest.getSubjectName())
                .build();
    }
    public SubjectResponse mapToSubjectResponse(Subject subject){
        return builder()
                .subjectName(subject.getSubjectName())
                .build();

    }

}
