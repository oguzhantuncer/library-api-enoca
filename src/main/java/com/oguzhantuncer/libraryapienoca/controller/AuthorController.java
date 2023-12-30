package com.oguzhantuncer.libraryapienoca.controller;

import com.oguzhantuncer.libraryapienoca.model.entity.Author;
import com.oguzhantuncer.libraryapienoca.model.request.AuthorRequest;
import com.oguzhantuncer.libraryapienoca.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public Author save(@RequestBody AuthorRequest request) {
        return authorService.save(request);
    }

    @PutMapping("/{id}")
    public Author update(@PathVariable Long id, AuthorRequest request) {
        return authorService.update(id, request);
    }

    @GetMapping
    public List<Author> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/")
    public Author getAuthorByNameAndSurname(@RequestParam String name,@RequestParam String surname) {
        return authorService.getAuthorByNameAndSurname(name, surname);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }

    @DeleteMapping
    public void deleteAll() {
        authorService.deleteAll();
    }
}
