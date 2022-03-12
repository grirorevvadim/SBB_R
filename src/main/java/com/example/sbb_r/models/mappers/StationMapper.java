package com.example.sbb_r.models.mappers;

import com.example.sbb_r.models.dtos.StationDto;
import com.example.sbb_r.models.entities.Station;
import org.springframework.stereotype.Component;

@Component
public class StationMapper {
    public Station dtoToEntity(StationDto dto) {
        Station station = new Station();
        station.setStationName(dto.getStationName());
        return station;
    }

    public StationDto entityToDto(Station station) {
        StationDto dto = new StationDto();
        dto.setStationName(station.getStationName());
        return dto;
    }
}
