package com.apisono.version1.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy mm:HH")
    private LocalDateTime date;

}
