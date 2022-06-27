package com.company.usecase.service;

import com.company.usecase.book.BookInformation;
import com.company.usecase.course.CourseInformation;

import java.util.List;

public interface CourseService {

    List<CourseInformation> findAll();

    List<BookInformation> findBooksByCourse(Long courseId);

}
