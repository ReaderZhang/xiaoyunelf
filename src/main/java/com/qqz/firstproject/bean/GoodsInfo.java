package com.qqz.firstproject.bean;/*
@Author qqz
@create 2020-04-15  13:31
*/

import com.qqz.firstproject.pojo.Goods;
import lombok.Data;

@Data
public class GoodsInfo extends Goods {
    private double price;
    private String type;

}
