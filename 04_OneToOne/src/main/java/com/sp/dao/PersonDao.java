package com.sp.dao;

import com.sp.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PersonDao {

    //根据id查询个人信息以及它的证件信息(嵌套查询)
    Person getPersonById(Integer id);


    //根据id查询个人信息以及它的证件信息(嵌套结果)
    Person getPersonById02(Integer id);

}
