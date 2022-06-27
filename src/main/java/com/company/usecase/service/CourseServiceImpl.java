package com.company.usecase.service;

import com.company.usecase.book.BookInformation;
import com.company.usecase.book.BookMapper;
import com.company.usecase.config.UtilityService;
import com.company.usecase.course.CourseInformation;
import com.company.usecase.entity.Book;
import com.company.usecase.entity.Course;
import com.company.usecase.repository.BookRepository;
import com.company.usecase.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository cRepository;

    private BookRepository bRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, BookRepository bookRepository) {
        this.cRepository = courseRepository;
        this.bRepository = bookRepository;
    }

    @PostConstruct
    public void postBean() {

        log.debug("Service to perform operations on course service bean creation...");

        List<Course> courses = cRepository.findAll();

        log.debug("Number of courses : {}", courses.size());

        UtilityService.courses = courses;

        List<Book> books = bRepository.findAll();

        BookMapper bookMapper = Mappers.getMapper(BookMapper.class);

        UtilityService.bookInfos = books.stream().map(bookMapper::toBookInformation).collect(Collectors.toList());
    }


    @Override
    public List<CourseInformation> findAll() {
        log.debug("Service to find all courses...");

        List<CourseInformation> courses = UtilityService.findCourses();

        return courses;
    }

    @Override
    public List<BookInformation> findBooksByCourse(Long courseId) {
        log.debug("Service to find books by course id : {}", courseId);

        List<BookInformation> books = UtilityService.findBooksByCourseId(courseId);

        return books;
    }
}
