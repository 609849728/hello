package com.sp.entity;

import lombok.Data;

@Data
public class History {

    private Integer id;

    private Integer type;

    private String parameter;

    private String result;

    private User user;

}
