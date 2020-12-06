package com.apisono.version1.model.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class QuestionCreateDTO {
    private Long userId;

    private LocalDate date;

    private String score;
}
