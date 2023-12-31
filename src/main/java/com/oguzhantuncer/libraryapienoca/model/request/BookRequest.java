package com.oguzhantuncer.libraryapienoca.model.request;

import com.oguzhantuncer.libraryapienoca.model.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private String name;
    private Author author;
    private String isbnNumber;
    private String publisher;
    private String numberOfEditions;
}
