package com.sp.service.impl;


import com.sp.dao.BookDao;
import com.sp.entity.Book;
import com.sp.service.BookService;
import com.sp.web.dao.IBaseDao;
import com.sp.web.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends BaseServiceImpl<Book> implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    protected IBaseDao<Book> getBaseDao() {
        return bookDao;
    }

}
