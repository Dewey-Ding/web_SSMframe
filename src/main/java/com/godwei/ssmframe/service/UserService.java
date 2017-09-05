package com.godwei.ssmframe.service;

import com.godwei.ssmframe.model.User;
import com.godwei.ssmframe.util.ActionReturnUtil;

import java.util.List;

public  interface UserService {
    ActionReturnUtil login(String userName,String passWord);
    ActionReturnUtil  getAll();
    ActionReturnUtil deleteUser(String userName);
    ActionReturnUtil updateUser(User user);
    ActionReturnUtil addUser(User user);
}
