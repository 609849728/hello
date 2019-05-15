package com.sp.mapper;

import com.sp.entity.Leave;

import java.util.List;

public interface LeaveMapper {

    //查询所有请假
    List<Leave> getLeaveList();

    //添加请假条
    int addLeave(Leave leave);

}