package com.sp.dao;


import com.sp.entity.Class;

public interface ClassDao {


    //多对多：根据id查询班级信息，并查询该班级教课的所有老师
    Class getClassById(Integer id);


}