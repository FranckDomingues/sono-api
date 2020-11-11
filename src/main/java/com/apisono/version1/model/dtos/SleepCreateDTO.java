package com.apisono.version1.model.dtos;

import com.apisono.version1.model.SleepStage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SleepCreateDTO {
    private SleepStageDTO stages;
    private int totalMinutesAsleep;
    private int totalTimeInBed;
    private LocalDateTime date;

}
@Data
class SleepStageDTO {
    private int deep;
    private int light;
    private int rem;
    private int wake;
}
