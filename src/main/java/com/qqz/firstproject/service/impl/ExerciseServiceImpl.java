package com.qqz.firstproject.service.impl;/*
@Author qqz
@create 2020-02-19  2:08
*/

import com.qqz.firstproject.dao.ExerciseMapper;
import com.qqz.firstproject.pojo.Exercise;
import com.qqz.firstproject.service.ExerciseService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseMapper mapper;

    @Override
    public List<Exercise> queryWrongExercise() {
        return mapper.selectWrongExercises ();
    }

    @Override
    public Exercise queryAWrongExerciseByEname(String ename) {
        return mapper.selectExerciseByName ( ename );
    }

    @Override
    public String queryAnswerByEid(Integer eid) {
        return mapper.selectAnswer ( eid );
    }

    @Override
    public boolean banExerciseById(Integer eid) {
        try {
            Exercise exercise = mapper.selectAWrongExercise ( eid );
            exercise.setStatus ( 0 );
            mapper.updateExercise ( exercise);
        }catch (Exception e){
            e.printStackTrace ();
            return false;
        }
        return  true;
    }

    @Override
    public boolean banExerciseByename(String ename) {
        try {
            Exercise exercise = mapper.selectExerciseByName ( ename );
            exercise.setStatus ( 0 );
            mapper.updateExercise ( exercise);
        }catch (Exception e){
            e.printStackTrace ();
            return false;
        }
        return true;
    }

    @Override
    public boolean changeExercise(Exercise exercise) {
        try {
            mapper.updateExercise ( exercise );
        }catch (Exception e){
            e.printStackTrace ();
            return false;
        }

        return true;
    }
}
