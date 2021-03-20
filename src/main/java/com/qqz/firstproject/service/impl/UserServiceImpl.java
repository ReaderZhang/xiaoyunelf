package com.qqz.firstproject.service.impl;/*
@Author qqz
@create 2020-05-07  17:33
*/

import com.qqz.firstproject.dao.UserMapper;
import com.qqz.firstproject.dto.UserDto;
import com.qqz.firstproject.pojo.User;
import com.qqz.firstproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User Login1(String phone , String password) {
        return userMapper.SelectAUserByPhonePassword ( phone, password );
    }


    @Override
    public void Register(UserDto userDto) {
        int num = userMapper.SelectCount ();
        userDto.setUid ( String.valueOf ( num+1 ) );
        userMapper.InsertUserDTO ( userDto );
    }

    @Override
    public void Overall(User user) {
        int num = userMapper.SelectCount ();
        user.setUid ( String.valueOf ( num+1 ) );
        userMapper.InsertUser ( user );
    }

    @Override
    public User Forget(String phone) {
        return userMapper.SelectAUserByPhone ( phone );
    }

    @Override
    public List<User> QueryAll() {
        return userMapper.SelectUsers ();
    }

    @Override
    public void ChangeUser(User user) {
        userMapper.UpdateUser ( user );
    }

    @Override
    public void BanUser(User user) {
        userMapper.UpdateUserStatus ( user );
    }

}
