package com.qqz.firstproject.dao;/*
@Author qqz
@create 2020-02-18  23:13
*/

import com.qqz.firstproject.pojo.Exercise;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExerciseMapper {
    List<Exercise> selectWrongExercises();

    Exercise selectAWrongExercise(int eid);

    String selectAnswer(int eid);

    Exercise selectExerciseByName(String ename);

    boolean insertExercise(Exercise exercise);

    boolean deleteExerciseByEid(int eid);

    boolean deleteExerciseByEname(String ename);

    boolean updateExercise(Exercise exercise);
}
