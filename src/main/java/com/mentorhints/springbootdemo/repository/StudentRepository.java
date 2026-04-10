package com.mentorhints.springbootdemo.repository;

import com.mentorhints.springbootdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    Optional<Student> findByName(String name);

}
