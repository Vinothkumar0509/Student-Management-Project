package com.mentorhints.springbootdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name ="subject_table")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String subjectName;

    @ManyToOne
    //Foreign Key(student id)
    //student class inside id is referred as student_id
    //owing side(where the Join column annotation is present)
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Student student;

}
