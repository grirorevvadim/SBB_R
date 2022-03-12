package com.example.sbb_r.controllers;

import com.example.sbb_r.models.dtos.StationDto;
import com.example.sbb_r.models.mappers.StationMapper;
import com.example.sbb_r.servises.interfaces.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("stations")
public class StationController {
    private final StationService stationService;
    private final StationMapper stationMapper;

    @GetMapping(path = "/{id}")
    public StationDto getStation(@PathVariable long id) {
        return stationMapper.entityToDto(stationService.getStation(id));
    }

    @GetMapping()
    public StationDto getStation(@RequestParam String stationName) {
        return stationMapper.entityToDto(stationService.getStationByStationName(stationName));
    }

    @PostMapping
    public StationDto createStation(@RequestBody StationDto stationDto) {
        return stationMapper.entityToDto(stationService.createStation(stationDto));
    }
}
