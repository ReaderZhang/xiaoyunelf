package com.qqz.firstproject.pojo;/*
@Author qqz
@create 2020-06-15  1:13
*/

import lombok.Data;

@Data
public class Collect {
    private String cid;
    private String content;
    private Integer type;
    private User user;
}
