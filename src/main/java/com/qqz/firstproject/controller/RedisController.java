package com.qqz.firstproject.controller;/*
@Author qqz
@create 2020-03-24  11:39
*/

import com.qqz.firstproject.Utils.xunfeiWebAPI.RedisUtils;
import com.qqz.firstproject.pojo.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisController {
    private static int ExpireTime = 60;

    @Resource
    private RedisUtils redisUtil;

    @RequestMapping("set")
    public boolean redisset(String key,String value){
        Goods good = new Goods ();
        good.setGoods_id ( 1 );
        good.setImg_src ( "baidu.com" );
        return redisUtil.set ( key,value );
    }
    @RequestMapping("get")
    public Object redisget(String key){
        return redisUtil.get ( key );
    }
    @RequestMapping("expire")
    public boolean expire(String key){
        return redisUtil.expire ( key,ExpireTime );
    }

}
