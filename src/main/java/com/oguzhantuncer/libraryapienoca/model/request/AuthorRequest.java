package com.oguzhantuncer.libraryapienoca.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {

    private String name;
    private String surname;
    private String birthDate;
    private String nations;
}
