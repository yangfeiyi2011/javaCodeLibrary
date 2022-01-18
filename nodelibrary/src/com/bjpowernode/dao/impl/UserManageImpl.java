package com.bjpowernode.dao.impl;

import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.bean.User;
import com.bjpowernode.dao.UserManage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManageImpl implements UserManage {
    /**
     * select user
     * @return userList
     */
    @Override
    public List<User> select() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH))) {
            List<User> list = (List<User>) ois.readObject();
            System.out.println(list.size());
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * add user
     * @param user
     */
    @Override
    public void addUser(User user) {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
            List<User> userList = (List<User>) ois.readObject();
            if (userList == null) {
                userList = new ArrayList<>();
                user.setId(1001);
            } else {
                User lastUser = userList.get(userList.size() - 1);
                user.setId(lastUser.getId() + 1);
            }
            userList.add(user);
            oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
            oos.writeObject(userList);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("写入数据异常");
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateUser(User user) {
        List<User> list = select();
        User userOri = list.stream().filter(u -> u.getId() == user.getId()).findFirst().get();
        userOri.setName(user.getName());
        userOri.setMoney(user.getMoney());
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
            oos.writeObject(list);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("更新数据异常");
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
