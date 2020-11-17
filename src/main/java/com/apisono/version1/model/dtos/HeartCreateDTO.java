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
