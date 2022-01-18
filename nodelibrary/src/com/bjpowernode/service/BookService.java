package com.bjpowernode.service;

import com.bjpowernode.bean.Book;

import java.util.List;

public interface BookService {
    /**
     * 查找书籍服务
     */
    List<Book> select();
}
