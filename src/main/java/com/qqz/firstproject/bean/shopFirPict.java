package com.qqz.firstproject.bean;/*
@Author qqz
@create 2020-02-11  23:44
*/

import com.qqz.firstproject.pojo.Picture;

public class shopFirPict extends Picture {
    private String open_type;
    private String navigator_url;

    public shopFirPict(String img_src , String name , String open_type , String navigator_url) {
        super ( img_src , name );
        this.open_type = open_type;
        this.navigator_url = navigator_url;
    }

    public shopFirPict(String open_type , String navigator_url) {
        this.open_type = open_type;
        this.navigator_url = navigator_url;
    }

    public String getOpen_type() {
        return open_type;
    }

    public void setOpen_type(String open_type) {
        this.open_type = open_type;
    }

    public String getNavigator_url() {
        return navigator_url;
    }

    public void setNavigator_url(String navigator_url) {
        this.navigator_url = navigator_url;
    }

    public shopFirPict() {
    }
}
