package com.qqz.firstproject.pojo;
import lombok.Data;

import java.util.Date;


@Data
public class User {
    private String uid;
    private String uname;
    private String grade;
    private String phone;
    private String password;
    private String image;
    private String gender;
    private Date starttime;
    private Integer status;
    private Role role;
}
