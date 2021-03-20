package com.qqz.firstproject.controller;/*
@Author qqz
@create 2020-06-15  16:35
*/

import com.qqz.firstproject.Response.ResponseResult;
import com.qqz.firstproject.pojo.Picture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CollectPictureController {
    private String urlpath = "47.95.214.19:8080/img/collect/";
    @GetMapping("/collectpicture/getPicture")
    public ResponseResult getPicture1(){
        List<Picture> list = new ArrayList<> ();
        list.add ( new Picture (urlpath+"collect_note1.png",null) );
        list.add ( new Picture (urlpath+"talkpane.png","笔记") );
        list.add ( new Picture (urlpath+"famous.png",null) );
        list.add ( new Picture (urlpath+"talkpane.png","名言") );
        list.add ( new Picture (urlpath+"bookshelt.png",null) );
        list.add ( new Picture (urlpath+"famous.png","书架") );
        return ResponseResult.Sucess (list);
    }
    @GetMapping("/collectpicture/getPicture2")
    public ResponseResult getPicture2(){
        List<Picture> list = new ArrayList<> ();
        list.add ( new Picture (urlpath+"collect_note2.png",null) );
        list.add ( new Picture (urlpath+"talkpane.png","笔记") );
        list.add ( new Picture (urlpath+"famous.png",null) );
        list.add ( new Picture (urlpath+"talkpane.png","名言") );
        list.add ( new Picture (urlpath+"bookshelt.png",null) );
        list.add ( new Picture (urlpath+"famous.png","书架") );
        return ResponseResult.Sucess (list);
    }
}
