package com.sp.dao;

import com.sp.entity.History;
import com.sp.web.mapper.IBaseMapper;

public interface HistoryDao extends IBaseMapper<History> {

    //根据手机号查询手机的归属地
    String getMobileCodeInfo(String parameter);

}
