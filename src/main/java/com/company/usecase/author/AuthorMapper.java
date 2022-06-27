package com.company.usecase.author;

import com.company.usecase.book.BookMapper;
import com.company.usecase.entity.Author;
import org.mapstruct.Mapper;

@Mapper(uses = BookMapper.class)
public interface AuthorMapper {

    public AuthorInformation toAuthorInfo(Author author);
}
