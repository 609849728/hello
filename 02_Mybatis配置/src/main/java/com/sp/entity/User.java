package com.sp.entity;

import lombok.Data;
import org.apache.ibatis.javassist.SerialVersionUID;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -6549323720322987661L;

    private Integer id;

    private String username;

    private String password;

}
