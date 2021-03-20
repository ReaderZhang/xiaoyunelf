package com.qqz.firstproject.controller;/*
@Author qqz
@create 2020-05-31  10:34
*/

import com.codeinchinese.英汉词典.英汉词典;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.qqz.firstproject.Response.ResponseResult;
import com.qqz.firstproject.dto.CiDto;
import com.qqz.firstproject.dto.WordDto;
import com.qqz.firstproject.pojo.Ci;
import com.qqz.firstproject.pojo.Word;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@CrossOrigin
@RestController
public class DictionaryController {
    private String wordfile = "/root/word.json";
    private String cifile = "/root/ci.json";
    @GetMapping("/dictionary/chinese-in-english/{word}")
    public ResponseResult Chinese_in_English(@PathVariable("word")String word){
        Object[] objects = new Object[2];
        objects[0] = "英文";
        objects[1] = 英汉词典.查词 (word);
        return ResponseResult.Sucess ( objects);
    }
    @GetMapping("/dictionary/xinhua/one/{word}")
    public ResponseResult xinhua(@PathVariable("word")String word) {
        Object[] objects = new Object[2];
        objects[0] = "字";
        try {
            FileInputStream fin = new FileInputStream ( wordfile );
            JsonReader reader = new JsonReader ( new InputStreamReader ( fin , "UTF-8" ) );
            Gson gson = new GsonBuilder ().create ();
            reader.beginArray ();
            while (reader.hasNext ()) {
                Word words = gson.fromJson ( reader , Word.class );
                WordDto wordDto = new WordDto ();
                wordDto.setWord ( words.getWord () );
                wordDto.setPinyin ( words.getPinyin () );
                wordDto.setStrokes ( words.getStrokes () );
                wordDto.setOldword ( words.getOldword () );
                wordDto.setRadicals ( words.getRadicals () );
                wordDto.setExplanation ( words.getExplanation ().split ( "\n\n" ) );
                wordDto.setMore ( words.getMore ().split ( "\n" ) );
                if (words.getWord ().equals ( word )) {
                    objects[1] = wordDto;
                    return ResponseResult.Sucess (objects);
                }
            }
            reader.close ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return ResponseResult.Fail ();

    }
    @GetMapping("/dictionary/xinhua/two/{ci}")
    public ResponseResult ci(@PathVariable("ci")String ci){
        Object[] objects = new Object[2];
        objects[0] = "词语";
        try {
            FileInputStream fin = new FileInputStream ( cifile );
            JsonReader reader = new JsonReader ( new InputStreamReader ( fin , "UTF-8" ) );
            Gson gson = new GsonBuilder ().create ();
            reader.beginArray ();
            while (reader.hasNext ()) {
                Ci ciyu = gson.fromJson ( reader , Ci.class );
                CiDto ciDto = new CiDto ();
                ciDto.setCi ( ciyu.getCi () );
                ciDto.setExplanations ( ciyu.getExplanation ().split ( "\n" ) );
                if (ciyu.getCi ().equals ( ci )) {
                    objects[1] = ciDto;
                    return ResponseResult.Sucess (objects);
                }
            }
            reader.close ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return ResponseResult.Sucess ("未找到匹配的词");
    }
    @GetMapping("/dictionary/{word}")
    public ResponseResult dictionary(@PathVariable("word")String word){
        Object[] obj = new Object[2];
        for (int i = 0;i<word.length ();i++){
            if (!((word.charAt ( i )<'z' && word.charAt ( i )>'a') || (word.charAt ( i )<'Z' && word.charAt ( i )>'A'))){
                if (word.length ()>=2){
//                    return ResponseResult.Sucess ("词");
                    try {
                        FileInputStream fin = new FileInputStream ( cifile );
                        JsonReader reader = new JsonReader ( new InputStreamReader ( fin , "UTF-8" ) );
                        Gson gson = new GsonBuilder ().create ();
                        reader.beginArray ();
                        while (reader.hasNext ()) {
                            Ci ciyu = gson.fromJson ( reader , Ci.class );
                            CiDto ciDto = new CiDto ();
                            ciDto.setCi ( ciyu.getCi () );
                            ciDto.setExplanations ( ciyu.getExplanation ().split ( "\n" ) );
                            if (ciyu.getCi ().equals ( word )) {
                                obj[0] = "词";
                                obj[1] = ciDto;
                                return ResponseResult.Sucess (obj);
                            }
                        }
                        reader.close ();
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }
                    return ResponseResult.Sucess ("未找到匹配的词");
                }else {
//                    return ResponseResult.Sucess ("字");
                    try {
                        FileInputStream fin = new FileInputStream ( wordfile );
                        JsonReader reader = new JsonReader ( new InputStreamReader ( fin , "UTF-8" ) );
                        Gson gson = new GsonBuilder ().create ();
                        reader.beginArray ();
                        while (reader.hasNext ()) {
                            Word words = gson.fromJson ( reader , Word.class );
                            WordDto wordDto = new WordDto ();
                            wordDto.setWord ( words.getWord () );
                            wordDto.setPinyin ( words.getPinyin () );
                            wordDto.setStrokes ( words.getStrokes () );
                            wordDto.setOldword ( words.getOldword () );
                            wordDto.setRadicals ( words.getRadicals () );
                            wordDto.setExplanation ( words.getExplanation ().split ( "\n\n" ) );
                            wordDto.setMore ( words.getMore ().split ( "\n" ) );
                            System.out.println (words);
                            if (words.getWord ().equals ( word )) {
                                obj[0] = "字";
                                obj[1] = wordDto;
                                return ResponseResult.Sucess (obj);
                            }
                        }
                        reader.close ();
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }
                    return ResponseResult.Fail ();
                }
            }else {
//                return ResponseResult.Sucess ("英文");
                obj[0] = "英文";
                obj[1] = 英汉词典.查词 ( word );
                return ResponseResult.Sucess ( obj);
            }
        }
        return ResponseResult.Fail ();
    }
}
