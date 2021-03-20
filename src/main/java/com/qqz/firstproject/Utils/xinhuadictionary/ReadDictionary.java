package com.qqz.firstproject.Utils.xinhuadictionary;/*
@Author qqz
@create 2020-05-31  10:51
*/

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.qqz.firstproject.pojo.Word;

import java.io.*;

public class ReadDictionary {
    public static void main(String[] args) {
        try{
            FileInputStream fin = new FileInputStream ( "src\\main\\java\\com\\qqz\\firstproject\\Utils\\xinhuadictionary\\word.json" );
            JsonReader reader = new JsonReader ( new InputStreamReader (fin,"UTF-8") );
            Gson gson = new GsonBuilder ().create ();
            reader.beginArray ();
            while(reader.hasNext ()){
                Word word = gson.fromJson ( reader,Word.class );
                if(word.getWord ().equals ( "丰" )){
                    System.out.println (word);
                    break;
                }
            }
            reader.close ();
        }catch(IOException e){
            e.printStackTrace ();
        }
    }


}
