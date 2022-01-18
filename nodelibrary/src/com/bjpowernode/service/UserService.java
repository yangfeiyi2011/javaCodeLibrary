package com.bjpowernode.service;

import com.bjpowernode.bean.User;

import java.util.List;

public interface UserService {

    /**
     * select user
     */
    List<User> selectService();

    /**
     * add user
     */
    void addService(User user);

    /**
     * update user
     */
    void updateService(User user);
}
