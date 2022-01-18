package com.bjpowernode.dao.impl;

import com.bjpowernode.bean.Book;
import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.dao.BookManage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BookManageImpl implements BookManage {
    @Override
    public List<Book> select() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PathConstant.BOOK_PATH))) {
            return (List<Book>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("读取图书文件失败！");
        }
    }
}
