package com.company.usecase.author;

import com.company.usecase.book.BookInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorInformation {

    private Long id;

    private String name;

    private String gender;

    private List<BookInformation> books;
}
