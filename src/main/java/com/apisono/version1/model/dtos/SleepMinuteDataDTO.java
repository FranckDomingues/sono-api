package com.apisono.version1.model.dtos;

import lombok.Data;

import java.time.LocalTime;

@Data
public class SleepMinuteDataDTO {
    private int value;
    private LocalTime dateTime;
}
