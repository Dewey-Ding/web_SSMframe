package com.godwei.ssmframe.mapper;

import com.godwei.ssmframe.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> getAllUser();
    User login(User user);
    int deleteUser(String userName);
    int updateUser(User user);
    int addUser(User user);
}
