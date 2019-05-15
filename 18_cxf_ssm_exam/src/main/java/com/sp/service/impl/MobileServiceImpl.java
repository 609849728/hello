package com.sp.service.impl;


import cn.com.webxml.MobileCodeWSSoap;
import com.sp.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileServiceImpl implements MobileService {

    @Autowired
    private MobileCodeWSSoap mobileCodeProxy;


    @Override
    public String getMobileCodeInfo(String mobileCode) {
        return mobileCodeProxy.getMobileCodeInfo(mobileCode,"");
    }

}
