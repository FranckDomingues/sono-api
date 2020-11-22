package com.apisono.version1.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SleepDataDTO {
    private int awakeCount;
    private int awakenDuration;
    private int awakeningsCount;
    private LocalDateTime dateOfSleep;
    private int duration;
    private int efficiency;
    private boolean isMainSleep;
    private int idLog;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy mm:HH")
    private LocalDateTime minuteData; //esta é uma lista de muitos dataTime não sei que atribuir
    private int minutesAfterWakeup;
    private int minutesAsleep;
    private int minutesAwake;
    private int minutesToFallAsleep;
    private int restlessCount;
    private int restlessDuration;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate startTime;
    private int timeInBed;

}
