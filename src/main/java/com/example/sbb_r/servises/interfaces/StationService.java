package com.example.sbb_r.servises.interfaces;

import com.example.sbb_r.models.dtos.StationDto;
import com.example.sbb_r.models.entities.Station;


public interface StationService {

    Station createStation(StationDto stationDto);
}