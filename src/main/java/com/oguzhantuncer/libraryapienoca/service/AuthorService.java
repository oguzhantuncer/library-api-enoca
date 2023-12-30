package com.oguzhantuncer.libraryapienoca.service;

import com.oguzhantuncer.libraryapienoca.model.entity.Author;
import com.oguzhantuncer.libraryapienoca.model.request.AuthorRequest;
import com.oguzhantuncer.libraryapienoca.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(AuthorRequest request) {
        Optional<Author> authorFromRepository= authorRepository.findByNameAndSurname(request.getName(), request.getSurname());

        if (authorFromRepository.isPresent()) {
            throw new RuntimeException("Author already exists.");
        }
        Author author = new Author();
        author.setName(request.getName());
        author.setSurname(request.getSurname());
        author.setBirthDate(request.getBirthDate());
        author.setNations(request.getNations());
        return authorRepository.save(author);
    }

    public Author update(Long id, AuthorRequest request) {
        Optional<Author> byId = authorRepository.findById(id);
        if(byId.isEmpty()){
            throw new RuntimeException("Author not found");
        }
        Author author = byId.get();
        author.setName(request.getName());
        author.setSurname(request.getSurname());
        author.setBirthDate(request.getBirthDate());
        author.setNations(request.getNations());
        return authorRepository.save(author);
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public Author getAuthorByNameAndSurname(String name, String surname) {
        return authorRepository.findByNameAndSurname(name, surname).get();
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    public void deleteAll() {
        authorRepository.deleteAll();
    }
}