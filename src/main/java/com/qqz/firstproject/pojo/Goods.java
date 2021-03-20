package com.qqz.firstproject.pojo;/*
@Author qqz
@create 2020-02-12  0:46
*/

import lombok.Getter;
import lombok.Setter;


public class Goods {
    private Integer goods_id;
    private String img_src;

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_id=" + goods_id +
                ", img_src='" + img_src + '\'' +
                '}';
    }

    public Goods() {
    }

    public Goods( String img_src,Integer goods_id ) {
        this.goods_id = goods_id;
        this.img_src = img_src;
    }
}
