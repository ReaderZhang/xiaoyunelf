package com.qqz.firstproject.service;/*
@Author qqz
@create 2020-06-15  18:26
*/

import com.qqz.firstproject.pojo.Collect;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CollectService {
    List<Collect> queryWord(String uid);
    List<Collect> queryPhase(String uid);
    List<Collect> querySentence(String uid);
}
