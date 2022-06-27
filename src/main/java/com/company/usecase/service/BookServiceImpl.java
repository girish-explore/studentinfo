package com.company.usecase.service;

import com.company.usecase.author.AuthorInformation;
import com.company.usecase.author.AuthorMapper;
import com.company.usecase.config.UtilityService;
import com.company.usecase.entity.Author;
import com.company.usecase.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookServiceImpl implements BookService{

    @Autowired
    private AuthorRepository aRepository;

/*    @Autowired
    public BookServiceImpl(AuthorRepository authorRepository) {
        this.aRepository = authorRepository;
    }*/

    @PostConstruct
    public void postBean() {

        log.debug("Service to perform operations on course service bean creation...");

        List<Author> authors = aRepository.findAll();

        AuthorMapper authorMapper = Mappers.getMapper(AuthorMapper.class);

        UtilityService.authorInfos = authors.stream().map(authorMapper::toAuthorInfo).collect(Collectors.toList());
    }

    @Override
    public List<AuthorInformation> findAuthorsByBook(Long bookId) {
        log.debug("Service to find authors by book id : {}", bookId);

        List<AuthorInformation> authorInfos = UtilityService.findAuthorsByBook(bookId);

        return authorInfos;
    }
}
