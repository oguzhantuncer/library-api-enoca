package com.oguzhantuncer.libraryapienoca.repository;

import com.oguzhantuncer.libraryapienoca.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByName(String name);

    Optional<Book> findByNameAndNumberOfEditions(String name, String numberOfEditions);
}
