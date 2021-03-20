package com.qqz.firstproject.controller;/*
@Author qqz
@create 2020-06-15  1:25
*/

import com.qqz.firstproject.Response.ResponseResult;
import com.qqz.firstproject.pojo.Picture;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class IndexController {
    private String urlpath = "47.95.214.19:8080/img/index/";
    @GetMapping("/index/Chart")
    public ResponseResult Chart(){
        List<String> list = new ArrayList<> ();
        list.add ( urlpath+"chart1.png" );
        list.add ( urlpath+"chart2.png" );
        list.add ( urlpath+"chart3.png" );
        return ResponseResult.Sucess (list);
    }
    @GetMapping("/index/lowpicture")
    public ResponseResult lowpicture(){
        List<Picture> list = new ArrayList<> ();
        list.add ( new Picture (urlpath+"collect.png","收藏") );
        list.add ( new Picture (urlpath+"collect_highlight.png","收藏") );
        list.add ( new Picture (urlpath+"study_home.png","学库") );
        list.add ( new Picture (urlpath+"study_home_highlight.png","学库") );
        list.add ( new Picture (urlpath+"xiaoyunelf.png","小云精灵") );
        list.add ( new Picture (urlpath+"xiaoyunelf_highlight.png","小云精灵") );
        list.add ( new Picture (urlpath+"shop.png","商城") );
        list.add ( new Picture (urlpath+"shop_highlight.png","商城") );
        list.add ( new Picture (urlpath+"meinfo.png","我") );
        list.add ( new Picture (urlpath+"meinfo_highlight.png","我") );
        return ResponseResult.Sucess (list);
    }
    @GetMapping("/index/toppicture")
    public ResponseResult toppicture(){
        List<String> list = new ArrayList<> ();
        list.add ( urlpath+"sign.png" );
        list.add ( urlpath+"talkpane.png" );
        return ResponseResult.Sucess (list);
    }
    @GetMapping("/index/midpicture")
    public ResponseResult midpicture(){
        List<Picture> list = new ArrayList<> ();
        list.add ( new Picture (urlpath+"mainpoint.png","主旨通") );
        list.add ( new Picture (urlpath+"getword.png","快速取词") );
        list.add ( new Picture (urlpath+"makesentence.png","用词造句") );
        list.add ( new Picture (urlpath+"test.png","测评报告") );
        list.add ( new Picture (urlpath+"note.png","笔记") );
        list.add ( new Picture (urlpath+"calender.png","名言") );
        list.add ( new Picture (urlpath+"signupinfo.png","签到") );
        list.add ( new Picture (urlpath+"more.png","更多") );
        return ResponseResult.Sucess (list);
    }
}
