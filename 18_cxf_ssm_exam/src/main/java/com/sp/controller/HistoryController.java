package com.sp.controller;

import com.github.pagehelper.PageInfo;
import com.sp.entity.History;
import com.sp.entity.User;
import com.sp.service.EnglishChineseService;
import com.sp.service.HistoryService;
import com.sp.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private MobileService mobileService;

    @Autowired
    private EnglishChineseService englishChineseService;


    @RequestMapping("/toMobileCodeInfo")
    public String toMobileCodeInfo() {
        return "mobileInfo";
    }

    @RequestMapping("/toTranslate")
    public String toTranslate() {
        return "translate";
    }


    @RequestMapping("/getMobileCodeInfo")
    public String getMobileCodeInfo(String mobileCode, Model model, HttpServletRequest request) {
        String mobileCodeInfo = mobileService.getMobileCodeInfo(mobileCode);

        History history = new History();
        history.setType(1);
        history.setParameter(mobileCode);
        history.setResult(mobileCodeInfo);
        User user = (User) request.getSession().getAttribute("USER_SESSION");
        history.setUser(user);

        historyService.insertSelective(history);

        model.addAttribute("mobileCodeInfo",mobileCodeInfo);
        return "mobileInfo";
    }


    @RequestMapping("/getTranslate")
    public String getTranslate(String parameter, Model model, HttpServletRequest request) {
        String result = englishChineseService.translate(parameter);

        History history = new History();
        history.setType(2);
        history.setParameter(parameter);
        history.setResult(result);
        User user = (User) request.getSession().getAttribute("USER_SESSION");
        history.setUser(user);

        historyService.insertSelective(history);

        model.addAttribute("result",result);
        return "translate";
    }


    @RequestMapping("/getHistoryPageInfo")
    public String getHistoryPageInfo(Integer pageNum,Integer pageSize,Model model) {
        PageInfo pageInfo = historyService.getPageInfo(pageNum, pageSize);

        model.addAttribute("page",pageInfo);
        model.addAttribute("pageUrl","/getHistoryPageInfo?");
        return "historyList";
    }



}
