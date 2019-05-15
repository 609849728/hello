package com.sp.service;

import com.github.pagehelper.PageInfo;
import com.sp.entity.Leave;

import java.util.List;

public interface LeaveService {

    //查询所有请假
    List<Leave> getLeaveList();

    //查询所有请假，分页
    PageInfo getLeavePageInfo(Integer pageNum,Integer pageSize);

    //添加请假条
    int addLeave(Leave leave);

}
