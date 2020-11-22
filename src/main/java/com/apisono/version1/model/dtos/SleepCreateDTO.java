package com.apisono.version1.model.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class SleepCreateDTO {
    private List<SleepDataDTO> sleepData=new ArrayList<>();
    private SleepStageDTO stages;
    private int totalMinutesAsleep;
    private int totalTimeInBed;
    private LocalDateTime date;

}
