package com.qqz.firstproject.bean;/*
@Author qqz
@create 2020-02-12  2:01
*/

import com.qqz.firstproject.pojo.Goods;
import lombok.Getter;
import lombok.Setter;


public class GoodsPict extends Goods {
    private String open_type;
    private String navigator;

    public String getOpen_type() {
        return open_type;
    }

    public void setOpen_type(String open_type) {
        this.open_type = open_type;
    }

    public String getNavigator() {
        return navigator;
    }

    public void setNavigator(String navigator) {
        this.navigator = navigator;
    }

    public GoodsPict(String open_type , String navigator) {
        this.open_type = open_type;
        this.navigator = navigator;
    }

    public GoodsPict(String img_src , Integer goods_id , String open_type , String navigator) {
        super ( img_src , goods_id );
        this.open_type = open_type;
        this.navigator = navigator;
    }
}
