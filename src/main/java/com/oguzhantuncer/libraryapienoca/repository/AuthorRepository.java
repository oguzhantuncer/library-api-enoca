package com.oguzhantuncer.libraryapienoca.repository;

import com.oguzhantuncer.libraryapienoca.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    Optional<Author> findByNameAndSurname(String name, String surname);
}
