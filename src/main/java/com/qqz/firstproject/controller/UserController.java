package com.qqz.firstproject.controller;/*
@Author qqz
@create 2020-06-14  0:52
*/

import com.qqz.firstproject.Response.ResponseResult;
import com.qqz.firstproject.Utils.xunfeiWebAPI.RedisUtils;
import com.qqz.firstproject.dto.UserDto;
import com.qqz.firstproject.pojo.User;
import com.qqz.firstproject.service.UserService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    private String filepath = "/data/image/";
    private String urlpath = "http://47.95.214.19/image/";
//    private String filepath = "src\\main\\resources\\static\\img\\";
//    private String urlpath = "http://localhost:8080/image/";
    private SimpleDateFormat sdf = new SimpleDateFormat ("yyyyMMdd");
    private final static String TPL_ID = "1974";
    private final static String TPL_VALUE = "#code#";
    private final static String KEY = "f8637f0b66264b848cbf6adc533e7ad1";
    private final static Logger LOGGER = LoggerFactory.getLogger ( UserController.class );

    @Resource
    private RedisUtils redisUtils;

    @Autowired
    private UserService userService;

    @GetMapping("/user/login/{phone}/{password}")
    public ResponseResult login(HttpSession session,@PathVariable("phone")String phone,@PathVariable("password")String password){
        User user = userService.Login1 ( phone,password );
        session.setAttribute ( "user",user );
        session.setMaxInactiveInterval ( 60*60 );
        if(ObjectUtils.isEmpty ( user )){
           return ResponseResult.Sucess ("账号或密码错误");
        }
        return ResponseResult.Sucess (user);
    }
    @GetMapping("/user/register/getMessage/{phone}")
    public ResponseResult getMessage(HttpSession session,@PathVariable("phone")String phone){
        boolean flag = false;
        List<User> users;
        users = userService.QueryAll ();
//        set = (redisUtils.sGet ( "number" ));
        if(ObjectUtils.isEmpty ( users )){
            users = userService.QueryAll ();
            for (User user:users){
                if (user.getPhone ().equals ( phone )){
                    return ResponseResult.Sucess ("此手机号已注册");
                }
            }
        }
        String s = "";
        for (int i = 0;i<6;i++){
            s+=(int)(Math.random ()*10);
        }
        LOGGER.info ( phone+"=============================>"+s );
        OkHttpClient client = new OkHttpClient ();
        Request request = new Request.Builder ()
                .url ( " http://apis.haoservice.com/sms/sendv2?key=" + KEY + "&mobile=" + phone + "&tpl_id=" + TPL_ID + "&content=【微云科技】若非本人操作，请忽略。您的验证码为"+s+",有效时长为5分钟&paybyvas=false" )
                .get ().build ();
        try {
            redisUtils.set ( phone,s );
            Response response = client.newCall ( request ).execute ();

//            session.setAttribute ( phone+"123",s );
//            session.setMaxInactiveInterval ( 5*60 );
//            LOGGER.info ( String.valueOf ( redisUtils.get ( phone )  )+"===============>"+s);
            LOGGER.info ( phone+"========================>"+s );
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return ResponseResult.Sucess ("验证码已发送");
    }
    @GetMapping("/register/sure/{phone}/{number}")
    public ResponseResult sure(HttpSession session, @PathVariable("number")String number, @PathVariable("phone")String phone){
//        String key = String.valueOf ( session.getAttribute ( phone+"123" ) );
        String key = String.valueOf ( redisUtils.get ( phone ) );
        System.out.println (phone+"========================makesure=======================>"+key);
        if(key.equals ( number )){
            return ResponseResult.Sucess ("验证码正确");
        }
        return ResponseResult.Sucess ("验证码错误");
    }
    @PutMapping("/register/{phone}/{password}/{uname}/{gender}/{grade}")
    public ResponseResult register(HttpSession session,@PathVariable("phone")String phone,@PathVariable("password")String password,@PathVariable("uname")String uname,
                                   @PathVariable("gender")String gender,@PathVariable("grade")String grade){
        UserDto userDto = new UserDto ();
        userDto.setGender ( gender );
        userDto.setPhone ( phone );
        userDto.setPassword ( password );
        userDto.setGrade ( grade );
        userDto.setImage ( String.valueOf ( redisUtils.get ( phone+"filename" )));
        userDto.setUname ( uname );
        System.out.println (String.valueOf ( redisUtils.get ( phone+"filename" )));
        userDto.setStarttime (new Date ());
        String pass = String.valueOf ( session.getAttribute ( "pass" ) );
        LOGGER.info ( "pass===================>"+pass );
            userService.Register ( userDto );
            return ResponseResult.Sucess ("注册成功");
    }
    @PostMapping("/upload/{phone}")
    public String uploading(@RequestParam("file") MultipartFile file,@PathVariable("phone")String phone ) {
        File targetFile = new File ( filepath );
        String path = file.getOriginalFilename ().substring ( 0 , file.getOriginalFilename ().indexOf ( "." ) );
        System.out.println ( file.getOriginalFilename () );
        System.out.println ( path );
        if (!targetFile.exists ()) {
            targetFile.mkdirs ();
        }
        try (FileOutputStream out = new FileOutputStream ( filepath + path + sdf.format ( new Date () ) + (String.valueOf ( (int) Math.random () * 10 )) + ".jpg" );) {
            redisUtils.set ( phone+"filename" , urlpath + path + sdf.format ( new Date () ) + (String.valueOf ( (int) Math.random () * 10 )) + ".jpg" );
            out.write ( file.getBytes () );
        } catch (Exception e) {
            e.printStackTrace ();
            return "uploading failure";
        }
        return "uploading success";
    }
}
