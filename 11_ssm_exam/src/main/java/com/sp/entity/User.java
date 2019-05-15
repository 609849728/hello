package com.sp.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private Integer id;

    private String name;

    private Integer age;

    private String password;

    private List<Book> bookList;

}
