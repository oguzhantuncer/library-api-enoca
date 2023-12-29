package com.oguzhantuncer.libraryapienoca.controller;

import com.oguzhantuncer.libraryapienoca.model.entity.Book;
import com.oguzhantuncer.libraryapienoca.model.request.BookRequest;
import com.oguzhantuncer.libraryapienoca.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody BookRequest request) {
        return bookService.update(id, request);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{name}")
    public List<Book> getBooksByName(@PathVariable String name) {
        return bookService.getBooksByName(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @DeleteMapping
    public void deleteAll() {
        bookService.deleteAll();
    }
}
