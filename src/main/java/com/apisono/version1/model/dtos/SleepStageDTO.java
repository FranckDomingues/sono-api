package com.apisono.version1.model.dtos;

import lombok.Data;

@Data
public class SleepStageDTO {
    private int deep;
    private int light;
    private int rem;
    private int wake;
}
