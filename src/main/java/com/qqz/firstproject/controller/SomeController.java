package com.qqz.firstproject.controller;/*
@Author qqz
@create 2020-05-29  16:26
*/

import com.qqz.firstproject.Response.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {
    @GetMapping("/some/1")
    public ResponseResult some1(){
        return ResponseResult.Sucess ("黄河入海流");
    }
}
