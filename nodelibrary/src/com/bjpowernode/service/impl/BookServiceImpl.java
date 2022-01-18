package com.bjpowernode.service.impl;

import com.bjpowernode.bean.Book;
import com.bjpowernode.dao.BookManage;
import com.bjpowernode.dao.impl.BookManageImpl;
import com.bjpowernode.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookManage bookManage = new BookManageImpl();

    @Override
    public List<Book> select() {
        return bookManage.select();
    }
}
