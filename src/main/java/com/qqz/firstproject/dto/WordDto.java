package com.qqz.firstproject.dto;/*
@Author qqz
@create 2020-06-13  14:50
*/

import lombok.Data;

@Data
public class WordDto {
    private String word;
    private String oldword;
    private String strokes;
    private String pinyin;
    private String radicals;
    private String[] explanation;
    private String[] more;
}
