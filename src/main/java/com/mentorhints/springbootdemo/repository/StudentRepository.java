package com.mentorhints.springbootdemo.repository;

import com.mentorhints.springbootdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    Optional<Student> findByName(String name);

    @Query(value = """
            select COUUNT(s.id)
            from student s
            where s.name = : name
            """, nativeQuery = true)
    Long getStudentCount(@Param("name")String name);

}
