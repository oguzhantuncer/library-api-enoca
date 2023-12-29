package com.oguzhantuncer.libraryapienoca.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String name;
    private String author;
    private String isbnNumber;
    private String publisher;
    private String numberOfEditions;
}
