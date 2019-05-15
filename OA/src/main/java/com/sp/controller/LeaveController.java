package com.sp.controller;

import com.github.pagehelper.PageInfo;
import com.sp.entity.Leave;
import com.sp.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/LeaveController")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;


    @RequestMapping("/getLeavePageInfo")
    public String getLeavePageInfo(Integer pageNum, Integer pageSize, Model model) {
        PageInfo pageInfo = leaveService.getLeavePageInfo(pageNum, pageSize);

        model.addAttribute("pageUrl","LeaveController/getLeavePageInfo?");
        model.addAttribute("page",pageInfo);
        return "leave/leaveList";
    }


    @RequestMapping("/addLeave")
    @ResponseBody
    public String addLeave(Leave leave) {
        int i = leaveService.addLeave(leave);

        if(i>0) {
            return "true";
        }
        return "false";
    }


}
