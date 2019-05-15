package com.sp.mapper;

import com.sp.entity.Dept;

import java.util.List;


public interface DeptMapper extends BaseMapper<Dept> {

    //获取Dept的树，也就是获取父级部门名称
    List<Dept> getDeptTree(Integer id);

}