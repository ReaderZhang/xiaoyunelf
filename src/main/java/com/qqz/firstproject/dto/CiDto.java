package com.qqz.firstproject.dto;/*
@Author qqz
@create 2020-06-13  14:49
*/

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CiDto {
    private String ci;
    private String[] explanations;
}
