package com.qqz.firstproject.service;/*
@Author qqz
@create 2020-05-07  17:23
*/

import com.qqz.firstproject.dto.UserDto;
import com.qqz.firstproject.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User Login1(String phone, String password);
    void Register(UserDto userDto);
    void Overall(User user);
    User Forget(String phone);
    List<User> QueryAll();
    void ChangeUser(User user);
    void BanUser(User user);
}
