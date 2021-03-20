package com.qqz.firstproject.pojo;/*
@Author qqz
@create 2020-02-11  4:19
*/

import lombok.Getter;
import lombok.Setter;


public class Picture {
    private String img_src;
    private String name;

    public Picture(String img_src , String name) {
        this.img_src = img_src;
        this.name = name;
    }

    public Picture() {
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
