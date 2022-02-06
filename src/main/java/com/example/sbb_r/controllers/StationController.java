package com.example.sbb_r.controllers;

import com.example.sbb_r.models.dtos.StationDto;
import com.example.sbb_r.models.entities.Station;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stations")
public class StationController {
    @GetMapping
    public String getStation() {
        return "get station was called";
    }

    @PostMapping
    public Station createStation(@RequestBody StationDto stationDto) {
        return new Station(stationDto.getStationName());
    }
}
