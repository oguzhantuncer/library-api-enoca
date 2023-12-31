package com.oguzhantuncer.libraryapienoca.service;

import com.oguzhantuncer.libraryapienoca.exception.BusinessException;
import com.oguzhantuncer.libraryapienoca.exception.DomainNotFoundException;
import com.oguzhantuncer.libraryapienoca.model.entity.Author;
import com.oguzhantuncer.libraryapienoca.model.request.AuthorRequest;
import com.oguzhantuncer.libraryapienoca.repository.AuthorRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(AuthorRequest request) {
        log.info("AuthorService.save is started with request: {} ", request);
        Optional<Author> authorFromRepository = authorRepository.findByNameAndSurname(request.getName(), request.getSurname());

        if (authorFromRepository.isPresent()) {
            log.error("AuthorService.save is failed with request: {} ", request);
            throw new BusinessException("author.already.exists");
        }
        Author author = new Author();
        author.setName(request.getName());
        author.setSurname(request.getSurname());
        author.setBirthDate(request.getBirthDate());
        author.setNations(request.getNations());
        log.info("AuthorService.save is completed with request: {} ", request);
        return authorRepository.save(author);
    }

    public Author update(Long id, AuthorRequest request) {
        log.info("AuthorService.update is started with id: {} and request: {} ", id, request);
        Optional<Author> byId = authorRepository.findById(id);
        if (byId.isEmpty()) {
            log.error("AuthorService.update is failed with id: {} and request: {} ", id, request);
            throw new DomainNotFoundException("author.not.found");
        }
        Author author = byId.get();
        author.setName(request.getName());
        author.setSurname(request.getSurname());
        author.setBirthDate(request.getBirthDate());
        author.setNations(request.getNations());
        log.info("AuthorService.update is completed with id: {} and request: {} ", id, request);
        return authorRepository.save(author);
    }

    public List<Author> getAll() {
        log.info("AuthorService.getAll is started");
        return authorRepository.findAll();
    }

    public Author getAuthorByNameAndSurname(String name, String surname) {
        log.info("AuthorService.getAuthorByNameAndSurname is started with name: {} and surname: {} ", name, surname);
        return authorRepository.findByNameAndSurname(name, surname).get();
    }

    public void delete(Long id) {
        log.info("AuthorService.delete is started with id: {} ", id);
        authorRepository.deleteById(id);
    }

    public void deleteAll() {
        log.info("AuthorService.deleteAll is started");
        authorRepository.deleteAll();
    }
}