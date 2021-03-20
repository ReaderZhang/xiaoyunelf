package com.qqz.firstproject.controller;/*
@Author qqz
@create 2020-06-02  14:44
*/

import com.qqz.firstproject.Response.ResponseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SummaryController {
    @Value ( "${summarypath}" )
    private String path;

    @GetMapping("/summary/{text}")
    public ResponseResult summary(@PathVariable("text")String text) throws Exception {
        String[] cmd = new String[4];
        cmd[0] = "python3";
        cmd[1] = "SummaryTxT.py";
        cmd[2] = "--text";
        cmd[3] = text;
        Process process = Runtime.getRuntime ().exec ( cmd,null,new File ( path ) );
        int status = process.waitFor ();
        System.out.println (status);
        if(status!=0){
            throw new Exception ("操作失败");
        }
        InputStream in = process.getInputStream ();
        BufferedReader br = new BufferedReader ( new InputStreamReader ( in,"UTF-8" ) );
        String line;
        List<String> lines = new ArrayList<> ();
        while ((line = br.readLine ())!=null){
            lines.add ( line );
        }
        br.close ();
        in.close ();
//        System.out.println (lines);
//        String result = lines.get ( 0 ).substring ( line.indexOf ( "--" ),line.length () );
        System.out.println (lines);
        System.out.println ("=========================");
        StringBuffer sb = new StringBuffer ();
        for (int i = 2;i<lines.size ();i++){
            sb.append ( lines.get ( i ) );
        }
        return ResponseResult.Sucess (sb);
    }
}
