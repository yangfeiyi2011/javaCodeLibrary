package com.bjpowernode.dao;

import com.bjpowernode.bean.User;

import java.util.List;

public interface UserManage {

    List<User> select();

    void addUser(User user);

    void updateUser(User user);
}
