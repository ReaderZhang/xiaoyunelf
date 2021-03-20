package com.qqz.firstproject.controller;/*
@Author qqz
@create 2020-06-01  11:48
*/

import com.baidu.aip.speech.AipSpeech;
import com.qqz.firstproject.Response.ResponseResult;
import com.qqz.firstproject.Utils.xunfeiSDK.LfasrSDKDemo;
import com.qqz.firstproject.Utils.xunfeiWebAPI.WebLfasrDemo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class SpeechController {
    public static final String APP_ID = "xxxxxxxxxxxxxxxxxxxx";
    public static final String API_KEY = "xxxxxxxxxxxxxxxxxxxxxxxxx";
    public static final String SECRET_KEY = "xxxxxxxxxxxxxxxxxxxxxxxxx";
    private SimpleDateFormat sdf = new SimpleDateFormat ("yyyyMMdd");
    @Value ( "${speechpath}" )
    private String filepath;

    @PostMapping("/speech/upload")
    public ResponseResult SpeechUpload(MultipartFile uploadFile , HttpSession session){
        File targetFile = new File ( filepath );
        File file = new File ( filepath+uploadFile.getOriginalFilename () );
        String filename = uploadFile.getOriginalFilename ();
        String realName = filepath+(String.valueOf ( (int)(Math.random ()*10)))+sdf.format ( new Date () )+uploadFile.getOriginalFilename ();
        if (!(filename.contains ( ".wav" )||filename.contains ( ".pcm" )||filename.contains ( ".amr" ))){
            return ResponseResult.Sucess ("上传文件的文件格式需为.wav/.pcm/.amr");
        }
        if(!targetFile.exists ()){
            targetFile.mkdirs ();
        }
        try{
            FileOutputStream out = new FileOutputStream ( realName );
            session.setAttribute ( "filepath",realName );
            out.write ( uploadFile.getBytes () );
            return ResponseResult.Sucess ();
        }catch (IOException e){
            return ResponseResult.Fail (e.getMessage ());
        }

    }
    @GetMapping("/speech/getMessage")
    public ResponseResult getMessage(HttpSession session){
        String filepath = (String) session.getAttribute ( "filepath" );
        AipSpeech client = new AipSpeech ( APP_ID,API_KEY,SECRET_KEY );
        JSONObject res = null;
        if(filepath.contains ( "wav" ))
            res = client.asr ( filepath,"wav",16000,null );
        if(filepath.contains ( "amr" ))
            res = client.asr ( filepath,"amr",16000,null );
        if(filepath.contains ( "pcm" ))
            res = client.asr ( filepath,"pcm",16000,null );
        return ResponseResult.Sucess (res.toString ());
    }
    @GetMapping("/xunfeiSDK/upload")
    public ResponseResult xunfeiSDKUpload(MultipartFile uploadFile,HttpSession session){
        File targetFile = new File ( filepath );
        File file = new File ( filepath+uploadFile.getOriginalFilename () );
        String filename = uploadFile.getOriginalFilename ();
        String realName = filepath+(String.valueOf ( (int)(Math.random ()*10)))+sdf.format ( new Date () )+uploadFile.getOriginalFilename ();
        if (!(filename.contains ( ".wav" )||filename.contains ( ".pcm" )||filename.contains ( ".amr" ))){
            return ResponseResult.Sucess ("上传文件的文件格式需为.wav/.pcm/.amr");
        }
        if(!targetFile.exists ()){
            targetFile.mkdirs ();
        }
        try{
            FileOutputStream out = new FileOutputStream ( realName );
            session.setAttribute ( "filepath",realName );
            out.write ( uploadFile.getBytes () );
            return ResponseResult.Sucess ();
        }catch (IOException e){
            return ResponseResult.Fail (e.getMessage ());
        }
    }
    @GetMapping("/xunfeiSDK/getMessage")
    public ResponseResult XunfeigetMessage(HttpSession session){
        String filepath = (String) session.getAttribute ( "filepath" );
        try {
            return ResponseResult.Sucess (LfasrSDKDemo.standard ( filepath ));
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        return ResponseResult.Fail ();
    }
    @GetMapping("/xunfei/getMessage")
    public ResponseResult xunfei(HttpSession session){
        String filepath = (String) session.getAttribute ( "filepath" );
        try {
            return ResponseResult.Sucess ( WebLfasrDemo.SPEECH ( filepath ) );
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return ResponseResult.Fail ();
    }
}
