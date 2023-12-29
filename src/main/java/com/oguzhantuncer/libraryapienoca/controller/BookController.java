package com.oguzhantuncer.libraryapienoca.controller;

import com.oguzhantuncer.libraryapienoca.model.entity.Book;
import com.oguzhantuncer.libraryapienoca.model.request.BookRequest;
import com.oguzhantuncer.libraryapienoca.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/book")
@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book save(@RequestBody BookRequest request) {
        return bookService.save(request);
    }
}
