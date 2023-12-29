package com.oguzhantuncer.libraryapienoca.service;

import com.oguzhantuncer.libraryapienoca.model.entity.Book;
import com.oguzhantuncer.libraryapienoca.model.request.BookRequest;
import com.oguzhantuncer.libraryapienoca.repository.BookRepository;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book save(BookRequest request){
        Optional<Book> bookFromRepository = bookRepository.findByName(request.getName());
        if(bookFromRepository.isPresent()){
            throw new RuntimeException("Book already exists");
        }
        Book book = Book.toEntity(request);
        return bookRepository.save(book);
    }
}
