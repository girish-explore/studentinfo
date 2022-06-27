package com.company.usecase.controller;

import com.company.usecase.request.StudentFilterRequest;
import com.company.usecase.request.StudentRequest;
import com.company.usecase.response.StudentResponse;
import com.company.usecase.service.StudentService;
import com.company.usecase.student.StudentInformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService sService;

    @PostMapping
    public ResponseEntity<StudentResponse> create(@RequestBody StudentRequest
                                                                request) {
        log.debug("request to create student : {}", request);

        StudentResponse response = sService.create(request);

        return new ResponseEntity<StudentResponse>(response, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<StudentInformation>> filter(@ModelAttribute StudentFilterRequest request) {
        log.debug("Request to find students by course name : {}", request);

        Page<StudentInformation> students = sService.findByCourseName(request);

        return new ResponseEntity<Page<StudentInformation>>(students, HttpStatus.OK);
    }


}
