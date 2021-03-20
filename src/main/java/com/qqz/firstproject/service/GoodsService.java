package com.qqz.firstproject.service;/*
@Author qqz
@create 2020-02-12  1:08
*/

import com.qqz.firstproject.pojo.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GoodsService {
    public List<Goods> queryRoChart();
}
