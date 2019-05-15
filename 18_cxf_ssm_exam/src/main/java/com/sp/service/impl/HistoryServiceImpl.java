package com.sp.service.impl;

import com.sp.dao.HistoryDao;
import com.sp.entity.History;
import com.sp.service.HistoryService;
import com.sp.web.mapper.IBaseMapper;
import com.sp.web.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl extends BaseServiceImpl<History> implements HistoryService {

    @Autowired
    private HistoryDao historyDao;

    @Override
    protected IBaseMapper<History> getBaseMapper() {
        return historyDao;
    }

}
