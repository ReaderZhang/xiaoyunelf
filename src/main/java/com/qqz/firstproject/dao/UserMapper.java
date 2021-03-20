package com.qqz.firstproject.dao;/*
@Author qqz
@create 2020-05-07  13:04
*/

import com.qqz.firstproject.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.qqz.firstproject.pojo.User;
import java.util.List;

@Mapper
public interface UserMapper {
    int SelectCount();
    User SelectAUserByPhonePassword(@Param( "phone" ) String phone, @Param( "password" ) String password);
    User SelectAUserByName(String uname);
    User SelectAUserByAccount(String account);
    User SelectAUserByPhone(String phone);
    List<User> SelectUsers();

    void InsertUserDTO(UserDto userDto);
    void InsertUser(User user);

    void UpdateUser(User user);
    void UpdateUserStatus(User user);

    void DeleteUserByPhone(String phone);
}
