package com.company.usecase.service;

import com.company.usecase.author.AuthorInformation;

import java.util.List;

public interface BookService {

    public List<AuthorInformation> findAuthorsByBook(Long bookId);
}
