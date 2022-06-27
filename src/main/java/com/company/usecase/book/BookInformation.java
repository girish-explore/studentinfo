package com.company.usecase.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInformation {

    private Long id;

    private String name;

    private LocalDate publishedDate;

    private Long courseId;
}
