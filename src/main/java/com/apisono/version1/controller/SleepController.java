package com.apisono.version1.controller;

import com.apisono.version1.model.dtos.SleepCreateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sleep")
public class SleepController {

    @PostMapping
    public ResponseEntity<SleepCreateDTO> createSleep(@RequestBody SleepCreateDTO sleepCreateDTO){
        System.out.println(sleepCreateDTO);
        return ResponseEntity.ok(sleepCreateDTO);
    }
}
