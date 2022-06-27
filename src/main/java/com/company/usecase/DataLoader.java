package com.company.usecase;

import java.time.LocalDate;
import java.util.*;

import com.company.usecase.entity.Author;
import com.company.usecase.entity.Book;
import com.company.usecase.entity.Course;
import com.company.usecase.entity.Student;
import com.company.usecase.repository.AuthorRepository;
import com.company.usecase.repository.BookRepository;
import com.company.usecase.repository.CourseRepository;
import com.company.usecase.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    private CourseRepository cRepository;

    @Autowired
    private StudentRepository sRepository;

    @Autowired
    private AuthorRepository aRepository;

    @Autowired
    private BookRepository bRepository;

    @Override
    public void run(String... args) throws Exception {

        LOGGER.debug("Service to load data...");

        Course course1 = new Course();
        course1.setName("AeroEnginer");
        course1.setStudents(new ArrayList<>());

        Course savedCourse1 = cRepository.save(course1);

        Course course2 = new Course();
        course2.setName("DataEnginer");
        course2.setStudents(new ArrayList<>());

        Course savedCourse2 = cRepository.save(course2);

        Author aeroAuthor1 = new Author();
        aeroAuthor1.setGender("male");
        aeroAuthor1.setName("Author Book 1");

        Author savedAeroAuthor1 = aRepository.save(aeroAuthor1);

        Author aeroAuthor2 = new Author();
        aeroAuthor2.setGender("female");
        aeroAuthor2.setName("Aero Author Book 2");

        Author savedAeroAuthor2 = aRepository.save(aeroAuthor2);

        Author dataAuthor1 = new Author();
        dataAuthor1.setGender("male");
        dataAuthor1.setName("Data Author Book 1");

        Author savedDataAuthor1 = aRepository.save(dataAuthor1);

        Author dataAuthor2 = new Author();
        dataAuthor2.setGender("female");
        dataAuthor2.setName("Data Author Book 2");

        Author savedDataAuthor2 = aRepository.save(dataAuthor2);

        Book aeroBook1 = new Book();
        aeroBook1.setCourseId(savedCourse1.getId());
        aeroBook1.setPublishedOn(LocalDate.now());
        aeroBook1.setName("Book1");
        aeroBook1.setPublication("Publishers");
        aeroBook1.setAuthors(new ArrayList<>());

        bRepository.save(aeroBook1);

        Book aeroBook2 = new Book();
        aeroBook2.setCourseId(savedCourse1.getId());
        aeroBook2.setPublishedOn(LocalDate.now());
        aeroBook2.setName("Book2");
        aeroBook2.setPublication("Not Publishers");
        aeroBook2.setAuthors(new ArrayList<>());

        bRepository.save(aeroBook2);

        Book dataBook1 = new Book();
        dataBook1.setCourseId(savedCourse2.getId());
        dataBook1.setPublishedOn(LocalDate.now());
        dataBook1.setName("dataBook1");
        dataBook1.setPublication("data Publishers");
        dataBook1.setAuthors(new ArrayList<>());

        bRepository.save(dataBook1);

        Book dataBook2 = new Book();
        dataBook2.setCourseId(savedCourse2.getId());
        dataBook2.setPublishedOn(LocalDate.now());
        dataBook2.setName("dataBook2");
        dataBook2.setPublication("Data Not Publishers");
        dataBook2.setAuthors(new ArrayList<>());

        bRepository.save(dataBook2);

        Student student1 = new Student();
        student1.setGender("male");
        student1.setName("Person1");
        student1.setCourses(new ArrayList<>());
        sRepository.save(student1);

        Student student2 = new Student();
        student2.setGender("male");
        student2.setName("Person2");
        student2.setCourses(new ArrayList<>());
        sRepository.save(student2);

        Student student3 = new Student();
        student3.setGender("male");
        student3.setName("Person3");
        student3.setCourses(new ArrayList<>());
        sRepository.save(student3);

    }
}
