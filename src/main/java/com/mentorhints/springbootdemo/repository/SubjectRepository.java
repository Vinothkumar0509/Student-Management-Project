package com.mentorhints.springbootdemo.repository;

import com.mentorhints.springbootdemo.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubjectRepository extends JpaRepository<Subject, UUID> {
}
