package com.sp.dao;


import com.sp.entity.Teacher;

public interface TeacherDao {

    //多对多：根据id查询老师信息，并查询出它所带的班级
    Teacher getTeacherById(Integer id);

}
