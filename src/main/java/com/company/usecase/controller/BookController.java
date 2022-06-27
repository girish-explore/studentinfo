package com.company.usecase.controller;

import com.company.usecase.author.AuthorInformation;
import com.company.usecase.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bService;

/*    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }*/

    @GetMapping("/{bookId}/authors")
    public ResponseEntity<List<AuthorInformation>> findAuthorsByBook(@PathVariable("bookId") Long bookId) {
        log.debug("Authors by book id : {}", bookId);

        List<AuthorInformation> authors = bService.findAuthorsByBook(bookId);

        return new ResponseEntity<List<AuthorInformation>>(authors, HttpStatus.OK);

    }
}
