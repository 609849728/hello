package com.sp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sp.entity.Leave;
import com.sp.mapper.LeaveMapper;
import com.sp.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveMapper leaveMapper;


    @Override
    public List<Leave> getLeaveList() {
        return leaveMapper.getLeaveList();
    }

    @Override
    public PageInfo getLeavePageInfo(Integer pageNum,Integer pageSize) {
        if(pageSize==null) {
            pageSize = 4;
        }

        if(pageNum==null || pageNum==0) {
            PageHelper.offsetPage(0,pageSize);
        } else {
            PageHelper.offsetPage((pageNum-1)*pageSize,pageSize);
        }

        List<Leave> list = leaveMapper.getLeaveList();

        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int addLeave(Leave leave) {
        return leaveMapper.addLeave(leave);
    }
}
