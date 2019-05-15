package com.sp.service.impl;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.EnglishChineseSoap;
import com.sp.service.EnglishChineseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnglishChineseServiceImpl implements EnglishChineseService {

    @Autowired
    private EnglishChineseSoap englishChineseProxy;


    @Override
    public String translate(String parameter) {
        ArrayOfString arrayOfString = englishChineseProxy.translatorString(parameter);
        List<String> list = arrayOfString.getString();
        StringBuilder sb = new StringBuilder();

        for(String s:list) {
            if(s!=null && s !="") {
                sb.append(s+",");
            }
        }
        return sb.toString();
    }

}
