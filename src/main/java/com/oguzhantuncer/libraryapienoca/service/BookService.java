package com.oguzhantuncer.libraryapienoca.service;

import com.oguzhantuncer.libraryapienoca.model.entity.Book;
import com.oguzhantuncer.libraryapienoca.model.request.BookRequest;
import com.oguzhantuncer.libraryapienoca.repository.BookRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book save(BookRequest request) {
        Optional<Book> existingBook = bookRepository.findByNameAndNumberOfEditions(request.getName(), request.getNumberOfEditions());

        if (existingBook.isPresent()) {
            throw new RuntimeException("Book already exists.");
        } else {
            Book book = Book.toEntity(request);
            return bookRepository.save(book);
        }
    }


    public Book update(Long id, BookRequest request) {
        Optional<Book> byId = bookRepository.findById(id);
        if(byId.isEmpty()){
            throw new RuntimeException("Book not found");
        }
        Book book = byId.get();
        book.setName(request.getName());
        book.setAuthor(request.getAuthor());
        book.setIsbnNumber(request.getIsbnNumber());
        book.setPublisher(request.getPublisher());
        book.setNumberOfEditions(request.getNumberOfEditions());
        return bookRepository.save(book);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByName(String bookName) {
        return bookRepository.findBooksByName(bookName);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
