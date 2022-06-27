package com.company.usecase.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentFilterRequest {

    private String courseName;

    private int page;

    private int size;
}
