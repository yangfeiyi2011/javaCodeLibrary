package com.bjpowernode.util;

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
        initData(null);
    }

    private static void initData(List<User> userList) {
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
                    User user = new User(1001, "Ñî·Ç", "Õý³£", new BigDecimal(100));
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

}
