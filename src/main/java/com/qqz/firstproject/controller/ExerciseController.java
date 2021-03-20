package com.qqz.firstproject.controller;/*
@Author qqz
@create 2020-02-19  2:23
*/

import com.qqz.firstproject.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController {
    @Autowired
    private ExerciseService service;
}
