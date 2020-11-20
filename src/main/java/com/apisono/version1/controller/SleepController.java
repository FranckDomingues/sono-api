package com.apisono.version1.controller;

import com.apisono.version1.model.Sleep;
import com.apisono.version1.model.SleepData;
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
                .date(LocalDate.from(sleepCreateDTO.getDate()))
                .user(userRepository.findById(1L).get())
                .build();

        sleep.setSleepDataList(
                sleepCreateDTO.getSleepData().stream().map(
                        sleepDataDTO -> SleepData.builder()
                     .sleep(sleep)
                     .awakeCount(sleepDataDTO.getAwakeCount())
                     .awakeningsCount(sleepDataDTO.getAwakeningsCount())
                     .awakenDuration(sleepDataDTO.getDuration())
                     .build()).collect(Collectors.toList()
                )

        );


        return ResponseEntity.ok(sleepRespository.save(sleep));
    }

}
