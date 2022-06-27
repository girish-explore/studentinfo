package com.company.usecase.course;

import com.company.usecase.entity.Course;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {

    public CourseInformation toCourseInformation(Course course);
}
