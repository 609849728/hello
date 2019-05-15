package com.sp.entity;

import lombok.Data;

@Data
public class Book {

    private Integer id;

    private String bookName;

    private Double price;

    private User user;

}
