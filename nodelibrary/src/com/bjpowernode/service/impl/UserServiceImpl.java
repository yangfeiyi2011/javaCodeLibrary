package com.bjpowernode.service.impl;

import com.bjpowernode.bean.User;
import com.bjpowernode.dao.UserManage;
import com.bjpowernode.dao.impl.UserManageImpl;
import com.bjpowernode.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserManage userManage = new UserManageImpl();

    @Override
    public List<User> selectService() {
        return userManage.select();
    }

    @Override
    public void addService(User user) {
        userManage.addUser(user);
    }

    @Override
    public void updateService(User user) {
        userManage.updateUser(user);
    }

    @Override
    public void deleteService(int id) {
        userManage.deleteUser(id);
    }

    @Override
    public void frozenService(int id) {
        userManage.frozenUser(id);
    }
}
