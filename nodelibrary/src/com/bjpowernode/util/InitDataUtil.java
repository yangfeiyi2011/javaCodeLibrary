package com.bjpowernode.util;

import com.bjpowernode.bean.Book;
import com.bjpowernode.bean.Constant;
import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.bean.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InitDataUtil {
    public static void main(String[] args) {
//        initUserData(null);
        initBookData(null);
    }

    private static void initUserData(List<User> userList) {
        File dir = new File("user");
        File file = new File(PathConstant.USER_PATH);
        if (!dir.exists()) {
            dir.mkdir();
        }
        if (!file.exists()) {
            ObjectOutputStream oos = null;
            try {
                file.createNewFile();
                oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
                List<User> list = new ArrayList<>();
                if (userList != null) {
                    list = userList;
                } else {
                    User user = new User(1001, "杨非", "正常", new BigDecimal(100));
                    list.add(user);
                }
                oos.writeObject(list);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (oos != null) {
                    try {
                        oos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void initBookData(List<Book> bookList) {
        File dir = new File("book");
        File file = new File(PathConstant.BOOK_PATH);
        if (!dir.exists()) {
            dir.mkdir();
        }
        if (!file.exists()) {
            ObjectOutputStream oos = null;
            try {
                file.createNewFile();
                oos = new ObjectOutputStream(new FileOutputStream(PathConstant.BOOK_PATH));
                List<Book> list = new ArrayList<>();
                if (bookList != null) {
                    list = bookList;
                } else {
                    Book book = new Book(1001, "java实践入门", "老杜", Constant.TYPE_COMPUTER, "12-987", "清华出版社", Constant.STATUS_STORAGE);
                    list.add(book);
                }
                oos.writeObject(list);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (oos != null) {
                    try {
                        oos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
