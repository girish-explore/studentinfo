package com.company.usecase.book;

import com.company.usecase.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    public BookInformation toBookInformation(Book book);

    public List<BookInformation> toBookInformation(List<Book> book);
}
