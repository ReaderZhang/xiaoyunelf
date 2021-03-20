package com.qqz.firstproject.service.impl;/*
@Author qqz
@create 2020-02-12  1:10
*/

import com.qqz.firstproject.dao.GoodsMapper;
import com.qqz.firstproject.pojo.Goods;
import com.qqz.firstproject.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> queryRoChart() {
        System.out.println (goodsMapper.selectGoodsList ());
        return goodsMapper.selectGoodsList ();
    }
}
