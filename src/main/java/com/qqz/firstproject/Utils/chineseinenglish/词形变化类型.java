package com.qqz.firstproject.Utils.chineseinenglish;/*
@Author qqz
@create 2020-05-30  21:21
*/

public enum 词形变化类型 {
    过去式("p"), // past tense
    过去分词("d"),
    现在分词("i"), // -ing
    第三人称单数("3"),
    形容词比较级("r"), // -er
    形容词最高级("t"), // -est
    名词复数形式("s"),
    原型("0"),
    原型变换形式("1");

    词形变化类型(String s) {
    }
}
