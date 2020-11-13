package com.apisono.version1.controller;

import com.apisono.version1.model.dtos.HeartCreateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/heart")
public class HeartController {
    /*private final HeartCreateDTO heartcreate;

      @Autowired
      public HeartController(HeartCreateDTO heartcreate){
        this.heartcreate = heartcreate;
      }
      @RequestMapping
      public ResponseEntity<Iterable<HeartCreateDTO>> getHeart(){
        return ResponseEntity.ok(HeartCreateDTO.findAll());
      }
     */

    @PostMapping
    public ResponseEntity<HeartCreateDTO> createHeart(@RequestBody HeartCreateDTO heartCreateDTO){
        System.out.println(heartCreateDTO);
        return ResponseEntity.ok(heartCreateDTO);
    }
}