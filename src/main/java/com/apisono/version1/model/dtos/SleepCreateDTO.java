package com.apisono.version1.model.dtos;

import com.apisono.version1.model.SleepStage;
import lombok.Data;

import java.time.LocalDate;
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
@Data
class SleepStageDTO {
    private int deep;
    private int light;
    private int rem;
    private int wake;
}
@Data
class SleepDataDTO {
    private int awakeCount;
    private int awakenDuration;
    private int awakeningsCount;
    private LocalDateTime dateOfSleep;
    private int duration;
    private int efefficiency;
    private boolean isMainSleep;
    private int idLog;
    //private () minuteData; esta é uma lista de muitos dataTime não sei que atribuir
    private int minutesAfterWakeup;
    private int minutesAsleep;
    private int minutesAwake;
    private int minutesToFallAsleep;
    private int restlessCount;
    private int restlessDuration;
    private LocalDate startTime;
    private int timeInBed;

}
