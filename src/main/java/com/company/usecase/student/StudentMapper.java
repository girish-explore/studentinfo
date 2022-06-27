package com.company.usecase.student;

import com.company.usecase.entity.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {

    public StudentInformation toStudentInformation(Student stu);

}
