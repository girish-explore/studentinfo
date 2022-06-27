package com.company.usecase.config;

import com.company.usecase.author.AuthorInformation;
import com.company.usecase.book.BookInformation;
import com.company.usecase.course.CourseInformation;
import com.company.usecase.course.CourseMapper;
import com.company.usecase.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class UtilityService {

    public static List<Course> courses;

    public static List<BookInformation> bookInfos;

    public static List<AuthorInformation> authorInfos;

    public static List<CourseInformation> findCourses() {

        log.debug("Service to load all the courses : {}", courses);

        CourseMapper curMapper = Mappers.getMapper(CourseMapper.class);

        List<CourseInformation> mappedCourses = courses.stream().map(curMapper::toCourseInformation).collect(Collectors.toList());

        return mappedCourses;
    }

    public static List<BookInformation> findBooksByCourseId(Long courseId) {

        log.debug("Service to find books by course id : {}", courseId);

        List<BookInformation> books = bookInfos.stream().filter(book -> book.getCourseId().equals(courseId)).collect(Collectors.toList());

        return books;
    }

    public static List<AuthorInformation> findAuthorsByBook(Long bookId) {
        log.debug("Authors by book id service : ", bookId);

        List<AuthorInformation> authors = authorInfos.stream().filter(author -> {
            List<Long> bookIds = author.getBooks().stream().map(bk -> bk.getId()).collect(Collectors.toList());

            return bookIds.contains(bookId);
        }).collect(Collectors.toList());

        return authors;
    }

    public static String test(String sr) { return null;}
}
