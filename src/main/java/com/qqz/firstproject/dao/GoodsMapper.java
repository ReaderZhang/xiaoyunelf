package com.qqz.firstproject.dao;/*
@Author qqz
@create 2020-02-12  1:03
*/

import com.qqz.firstproject.bean.GoodsInfo;
import com.qqz.firstproject.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.List;
@Mapper
public interface GoodsMapper {
    public List<Goods> selectGoodsList();
    public GoodsInfo selectGoodsInfo(Integer goods_id);
}
