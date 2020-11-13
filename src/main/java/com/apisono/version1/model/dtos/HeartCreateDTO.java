package com.apisono.version1.model.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class HeartCreateDTO { //2 Atributos
    private List<HeartZonesDTO> heartZones=new ArrayList<>(); //Lista
    private LocalDate date; //Data
}
@Data
class HeartZonesDTO {
    private float caloriesOut;
    private int max;
    private int min;
    private int minutes;
    private String name;
}