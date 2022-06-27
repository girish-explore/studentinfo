package com.company.usecase.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    public static final String MESSAGE = "SUCCESS";

    private Long id;

    private String message;
}
