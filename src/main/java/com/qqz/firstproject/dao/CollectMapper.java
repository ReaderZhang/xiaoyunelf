package com.qqz.firstproject.dao;/*
@Author qqz
@create 2020-06-15  17:13
*/

import com.qqz.firstproject.pojo.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectMapper {
    List<Collect> selectCollectNote(@Param ( "uid" ) String uid, @Param ( "type" ) Integer type);
    void insertCollectNote(Collect collect);
    void deleteCollectNote(Collect collect);
}
