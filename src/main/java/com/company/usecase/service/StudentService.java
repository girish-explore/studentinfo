package com.company.usecase.service;

import com.company.usecase.request.StudentFilterRequest;
import com.company.usecase.request.StudentRequest;
import com.company.usecase.response.StudentResponse;
import com.company.usecase.student.StudentInformation;
import org.springframework.data.domain.Page;

public interface StudentService {
    StudentResponse create(StudentRequest request);

    Page<StudentInformation> findByCourseName(StudentFilterRequest request);
}
