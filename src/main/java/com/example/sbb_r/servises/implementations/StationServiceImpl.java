package com.example.sbb_r.servises.implementations;

import com.example.sbb_r.models.dtos.StationDto;
import com.example.sbb_r.models.entities.Station;
import com.example.sbb_r.servises.interfaces.StationService;
import org.springframework.stereotype.Service;

@Service
public class StationServiceImpl implements StationService {
    @Override
    public Station createStation(StationDto stationDto) {
        return new Station(stationDto.getStationName());
    }
}
