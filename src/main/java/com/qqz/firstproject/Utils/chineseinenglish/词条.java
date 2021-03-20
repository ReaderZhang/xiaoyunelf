package com.qqz.firstproject.Utils.chineseinenglish;/*
@Author qqz
@create 2020-05-30  21:17
*/

import com.codeinchinese.英汉词典.词形变化;
import lombok.Data;

import java.util.List;

@Data
public class 词条 {
    private String 英文;
    private String 音标;
    private List<String> 英文释义;
    private List<String> 中文释义;
    private String 词语位置;
    private int 柯林斯星级;
    private boolean 为牛津三千核心词;

    // zk/中考，gk/高考，cet4/四级等
    private String 标签;

    // 如果为0, 无词频数据, 否则为正数
    private int 英国国家语料库词频顺序;
    private int 当代语料库词频顺序;

    private List<词形变化> 变形;
    private String 详细;
    private String 在线读音音频;
}
