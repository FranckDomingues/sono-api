package com.apisono.version1.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SleepDataDTO {
    private int awakeCount;
    private int awakenDuration;
    private int awakeningsCount;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate dateOfSleep;
    private int duration;
    private int efficiency;
    private boolean isMainSleep;
    private int idLog;
    private List<SleepMinuteDataDTO> minuteData; //esta é uma lista de muitos dataTime não sei que atribuir
    private int minutesAfterWakeup;
    private int minutesAsleep;
    private int minutesAwake;
    private int minutesToFallAsleep;
    private int restlessCount;
    private int restlessDuration;
//    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDateTime startTime;
    private int timeInBed;

}
