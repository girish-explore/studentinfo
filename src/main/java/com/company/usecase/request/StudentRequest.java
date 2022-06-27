package com.company.usecase.request;

import com.company.usecase.student.StudentCourses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {

    private String name;

    private String gender;

    private List<StudentCourses> courses;
}
