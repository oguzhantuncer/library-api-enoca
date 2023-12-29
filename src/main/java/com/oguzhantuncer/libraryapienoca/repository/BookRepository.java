package com.oguzhantuncer.libraryapienoca.repository;

import com.oguzhantuncer.libraryapienoca.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findByName(String name);

}
