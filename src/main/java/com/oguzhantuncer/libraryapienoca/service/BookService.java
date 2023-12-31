package com.oguzhantuncer.libraryapienoca.service;

import com.oguzhantuncer.libraryapienoca.exception.BusinessException;
import com.oguzhantuncer.libraryapienoca.exception.DomainNotFoundException;
import com.oguzhantuncer.libraryapienoca.model.entity.Book;
import com.oguzhantuncer.libraryapienoca.model.request.BookRequest;
import com.oguzhantuncer.libraryapienoca.repository.BookRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book save(BookRequest request) {
        log.info("BookService.save is started with request: {} ", request);
        Optional<Book> existingBook = bookRepository.findByNameAndNumberOfEditions(request.getName(), request.getNumberOfEditions());

        if (existingBook.isPresent()) {
            log.error("BookService.save is failed with request: {} ", request);
            throw new BusinessException("book.already.exists");
        } else {
            Book book = Book.toEntity(request);
            log.info("BookService.save is completed with request: {} ", request);
            return bookRepository.save(book);
        }
    }


    public Book update(Long id, BookRequest request) {
        log.info("BookService.update is started with id: {} and request: {} ", id, request);
        Optional<Book> byId = bookRepository.findById(id);
        if(byId.isEmpty()){
            log.error("BookService.update is failed with id: {} and request: {} ", id, request);
            throw new DomainNotFoundException("book.not.found");
        }
        Book book = byId.get();
        book.setName(request.getName());
        book.setAuthor(request.getAuthor());
        book.setIsbnNumber(request.getIsbnNumber());
        book.setPublisher(request.getPublisher());
        book.setNumberOfEditions(request.getNumberOfEditions());
        log.info("BookService.update is completed with id: {} and request: {} ", id, request);
        return bookRepository.save(book);
    }

    public List<Book> getAll() {
        log.info("BookService.getAll is started");
        return bookRepository.findAll();
    }

    public List<Book> getBooksByName(String bookName) {
        log.info("BookService.getBooksByName is started with bookName: {} ", bookName);
        return bookRepository.findBooksByName(bookName);
    }

    public void delete(Long id) {
        log.info("BookService.delete is started with id: {} ", id);
        bookRepository.deleteById(id);
    }

    public void deleteAll() {
        log.info("BookService.deleteAll is started");
        bookRepository.deleteAll();
    }
}
