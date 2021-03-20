package com.qqz.firstproject.controller;/*
@Author qqz
@create 2020-06-01  16:59
*/

import com.qqz.firstproject.Response.ResponseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class OcrController {
    private SimpleDateFormat sdf = new SimpleDateFormat ("yyyyMMdd");
    @Value( "${ocrpath}" )
    private String filepath;
    @Value ( "${resultpath}" )
    private String resultpath;
    @Value ( "${ocrstartpath}" )
    private String startpath;
    @PostMapping("/ocr/upload")
    public ResponseResult ocrUpload(MultipartFile uploadFile, HttpSession session){
        File targetFile = new File ( filepath );
        File file = new File ( filepath+uploadFile.getOriginalFilename () );
        String filename = uploadFile.getOriginalFilename ();
        String realName = filepath+(String.valueOf ( (int)(Math.random ()*10)))+sdf.format ( new Date () )+uploadFile.getOriginalFilename ();
        if(!targetFile.exists ()){
            targetFile.mkdirs ();
        }
        try{
            FileOutputStream out = new FileOutputStream ( realName );
            session.setAttribute ( "ocrpath",realName );
            out.write ( uploadFile.getBytes () );
            out.close ();
            return ResponseResult.Sucess ("123");
        }catch (IOException e){
            return ResponseResult.Fail (e.getMessage ());
        }
    }
    @GetMapping("/ocr/getMessage")
    public ResponseResult getMessage(HttpSession session) throws IOException, InterruptedException {
        String[] cmd = new String[2];
        cmd[0] = "python";
        cmd[1] = "demo.py";
        Process process = Runtime.getRuntime ().exec(cmd,null,new File ( startpath ));
//        int status = process.waitFor ();
//        if(status!=0){
//            return ResponseResult.Fail ("错误码为:"+status);
//        }
        InputStream in = process.getInputStream ();
        BufferedReader br = new BufferedReader ( new InputStreamReader ( in,"UTF-8" ) );
        String line;
        List<String> lines  = new ArrayList<> ();
        while((line=br.readLine ())!=null){
            lines.add ( line );
        }
        String imagename = String.valueOf ( session.getAttribute ( "ocrpath" ) );
        if(imagename.equals ( "" ))
            return ResponseResult.Fail ("文件不存在");
        String filename;
        if(imagename.contains ( ".png" )){
            filename = imagename.replace ( ".png",".txt" );
        }else if(imagename.contains ( ".jpg" )){
            filename = imagename.replace ( ".jpg",".txt" );
        }else {
            filename="";
        }
        File imagefile = new File ( imagename );
        br.close ();
        in.close ();
//        if(imagefile.exists() && imagefile.isFile()){
//            if(imagefile.delete ()){
//                System.out.println (imagename+"===============>已删除");
//            }else{
//                System.out.println ("删除失败");
//            }
//        }
        System.out.println (imagename);
        System.out.println ("boolean=====================>exists"+imagefile.exists ());
        System.out.println ("boolean=====================>delete"+imagefile.delete ());
        return ResponseResult.Sucess (lines);
    }
}
