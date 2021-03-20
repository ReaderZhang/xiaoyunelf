package com.qqz.firstproject.dto;/*
@Author qqz
@create 2020-05-07  13:49
*/

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class UserDto {
    private String uid;
    private String uname;
    private String gender;
    private String grade;
    private String password;
    private String phone;
    private String image;
    private Date starttime;
}
