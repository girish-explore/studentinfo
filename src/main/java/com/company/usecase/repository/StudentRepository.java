package com.company.usecase.repository;

import com.company.usecase.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    //List<Student> findByFirstName(String name);
    Page<Student> findByCoursesName(String courseName, Pageable pageable);
}
