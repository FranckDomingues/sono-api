package com.apisono.version1.controller;

import com.apisono.version1.model.Heart;
import com.apisono.version1.model.HeartZone;
import com.apisono.version1.model.User;
import com.apisono.version1.model.dtos.HeartCreateDTO;
import com.apisono.version1.repository.HeartRepository;
import com.apisono.version1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/heart")
public class HeartController {
    private final HeartRepository heartRepository;
    private final UserRepository userRepository;

    public HeartController(HeartRepository heartRepository, UserRepository userRepository) {
        this.heartRepository = heartRepository;
        this.userRepository = userRepository;
    }
 @RequestMapping
      public ResponseEntity<Iterable<Heart>> getHeart(){
        return ResponseEntity.ok(heartRepository.findAll());
      }


    @PostMapping
    public ResponseEntity<Heart> createHeart(@RequestBody HeartCreateDTO heartCreateDTO){
        //System.out.println(heartCreateDTO);

        Heart heart=Heart.builder()
                .date(heartCreateDTO.getDate())
                //.user(new User())//buscar utilizador na bd
                .user(userRepository.findById(1L).get())
                .build();

        heart.setHeartZoneList(
                heartCreateDTO.getHeartZones().stream().map(
                        heartZonesDTO -> HeartZone.builder()
                    .heart(heart)
                    .caloriesOut(heartZonesDTO.getCaloriesOut())
                    .max(heartZonesDTO.getMax())
                    .min(heartZonesDTO.getMin())
                    .minutes(heartZonesDTO.getMinutes())
                    .name(heartZonesDTO.getName())
                    .build()).collect(Collectors.toList()
                )
        );

        return ResponseEntity.ok(heartRepository.save(heart));
    }
}
