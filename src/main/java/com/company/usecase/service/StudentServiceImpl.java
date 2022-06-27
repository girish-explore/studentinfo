package com.company.usecase.service;

import com.company.usecase.entity.Course;
import com.company.usecase.entity.Student;
import com.company.usecase.repository.CourseRepository;
import com.company.usecase.repository.StudentRepository;
import com.company.usecase.request.StudentFilterRequest;
import com.company.usecase.request.StudentRequest;
import com.company.usecase.response.StudentResponse;
import com.company.usecase.student.StudentCourses;
import com.company.usecase.student.StudentInformation;
import com.company.usecase.student.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository sRepository;

    @Autowired
    private CourseRepository cRepository;

/*
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.cRepository = courseRepository;
        this.sRepository = studentRepository;
    }
*/

    @Override
    public StudentResponse create(StudentRequest request) {
        log.debug("Create Student Service : ", request);

        Student s1 = new Student();
        s1.setName(request.getName());
        s1.setGender(request.getGender());

        List<Course> courses = new ArrayList<>();

        for (StudentCourses cur : request.getCourses()) {
            var foundCourse = cRepository.findById(cur.getId());

            if (foundCourse.isPresent()) {
                courses.add(foundCourse.get());
            } else {
                throw new EntityNotFoundException("NOt Found : " + cur.getId());
            }
        }

        s1.setCourses(courses);

        sRepository.save(s1);

        return new StudentResponse(s1.getId(), StudentResponse.MESSAGE);
    }

    @Override
    public Page<StudentInformation> findByCourseName(StudentFilterRequest request) {
        log.debug("Service to find students by course name : {}", request);

        PageRequest pageable = PageRequest.of(request.getPage(), request.getSize());

        Page<Student> students = sRepository.findByCoursesName(request.getCourseName(), pageable);

        StudentMapper stuMapper = Mappers.getMapper(StudentMapper.class);

        List<StudentInformation> studentsInfo = students.stream().map(stuMapper::toStudentInformation).collect(Collectors.toList());

        return new PageImpl<>(studentsInfo, students.getPageable(), students.getTotalElements());
    }

}
