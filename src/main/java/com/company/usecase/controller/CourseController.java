package com.company.usecase.controller;

import com.company.usecase.book.BookInformation;
import com.company.usecase.course.CourseInformation;
import com.company.usecase.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService cService;

    @GetMapping
    public ResponseEntity<List<CourseInformation>> findAll() {
        log.debug("All courses are");

        List<CourseInformation> courses = cService.findAll();

        return new ResponseEntity<List<CourseInformation>>(courses, HttpStatus.OK);
    }

    @GetMapping("/{courseId}/books")
    public ResponseEntity<List<BookInformation>> findBooksByCourse(@PathVariable("courseId") Long courseId) {
        log.debug("Books by course id : ", courseId);

        List<BookInformation> books = cService.findBooksByCourse(courseId);

        return new ResponseEntity<List<BookInformation>>(books, HttpStatus.OK);
    }
}
