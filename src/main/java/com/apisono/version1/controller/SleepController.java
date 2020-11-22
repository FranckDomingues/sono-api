package com.apisono.version1.controller;

import com.apisono.version1.model.Sleep;
import com.apisono.version1.model.SleepData;
import com.apisono.version1.model.SleepMinuteData;
import com.apisono.version1.model.User;
import com.apisono.version1.model.dtos.SleepCreateDTO;
import com.apisono.version1.repository.SleepRepository;
import com.apisono.version1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/sleep")
public class SleepController {
    private final SleepRepository sleepRepository;
    private final UserRepository userRepository;

    public SleepController(SleepRepository sleepRepository, UserRepository userRepository) {
        this.sleepRepository = sleepRepository;
        this.userRepository = userRepository;
    }
 @RequestMapping
      public ResponseEntity<Iterable<Sleep>> getSleep(){
        return ResponseEntity.ok(sleepRepository.findAll());
      }


    @PostMapping
    public ResponseEntity<Sleep> createSleep(@RequestBody SleepCreateDTO sleepCreateDTO){
        //System.out.println(sleepCreateDTO);

        Sleep sleep=Sleep.builder()
//                .date(sleepCreateDTO.getSleep().get(0).getStartTime())
                .user(userRepository.findById(1L).get())
                .sleepDataList(new ArrayList<>())
                .build();


        sleepCreateDTO.getSleep().forEach(sleepDataDTO ->{
                   SleepData sleepData= SleepData.builder()
                           //terminar os outros atributos
                            .awakeCount(sleepDataDTO.getAwakeCount())
                            .awakeningsCount(sleepDataDTO.getAwakeningsCount())
                            .awakenDuration(sleepDataDTO.getAwakenDuration())
                            .dateOfSleep(sleepDataDTO.getDateOfSleep())
                            .duration(sleepDataDTO.getDuration())
                           .minuteData(new ArrayList<>())
                            .efficiency(sleepDataDTO.getEfficiency())
                            .minutesAwake(sleepDataDTO.getMinutesAwake())
                            .build();
                   sleepDataDTO.getMinuteData().forEach(sleepMinuteDataDTO ->
                           {
                               SleepMinuteData sleepMinuteData=SleepMinuteData.builder()
                                       .value(sleepMinuteDataDTO.getValue())
                                       .dateTime(sleepMinuteDataDTO.getDateTime())
                                       .build();
                               sleepData.addSleepMinuteData(sleepMinuteData);
                           }
                   );
                 sleep.addSleepData(sleepData);
                 sleep.setDate(sleepData.getDateOfSleep());
                }
        );

        return ResponseEntity.ok(sleepRepository.save(sleep));
    }

}
