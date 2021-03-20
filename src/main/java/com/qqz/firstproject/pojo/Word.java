package com.qqz.firstproject.pojo;/*
@Author qqz
@create 2020-05-31  12:57
*/

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Word {
    private String word;
    private String oldword;
    private String strokes;
    private String pinyin;
    private String radicals;
    private String explanation;
    private String more;
}
