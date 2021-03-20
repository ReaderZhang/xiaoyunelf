package com.qqz.firstproject.service;/*
@Author qqz
@create 2020-02-19  1:51
*/

import com.qqz.firstproject.pojo.Exercise;

import java.util.List;

public interface ExerciseService {
    List<Exercise> queryWrongExercise();

    Exercise queryAWrongExerciseByEname(String ename);

    String queryAnswerByEid(Integer eid);

    boolean banExerciseById(Integer eid);

    boolean banExerciseByename(String ename);

    boolean changeExercise(Exercise exercise);
}
