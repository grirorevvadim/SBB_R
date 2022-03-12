package com.example.sbb_r.servises.implementations;

import com.example.sbb_r.exceptions.EntityNotFound;
import com.example.sbb_r.models.dtos.StationDto;
import com.example.sbb_r.models.entities.Station;
import com.example.sbb_r.repositories.StationRepository;
import com.example.sbb_r.servises.interfaces.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StationServiceImpl implements StationService {
    private final StationRepository stationRepository;

    @Override
    public Station createStation(StationDto stationDto) {
        var station = new Station();
        station.setStationName(stationDto.getStationName());
        stationRepository.save(station);
        return station;
    }

    @Override
    public Station getStation(long id) {
        var station = stationRepository.findById(id);
        if (station.isEmpty()) throw new EntityNotFound("Station with id " + id + " is not found");
        return station.get();
    }

    @Override
    public Station getStationByStationName(String stationName) {
        var station = stationRepository.findStationByStationName(stationName);
        if (station == null) throw new EntityNotFound("Station with stationName "
                + stationName + " is not found");
        return station;
    }

    @Override
    public Station updateStation(long id, StationDto stationDto) {
        var station = stationRepository.findById(id);
        if (station.isEmpty()) throw new EntityNotFound("Station with id " + id + " was not found");
        var updatedStation = station.get();
        if (stationDto.getStationName() != null) updatedStation.setStationName(stationDto.getStationName());
        stationRepository.save(updatedStation);
        return updatedStation;
    }

    @Override
    public String deleteStation(long id) {
        var station = stationRepository.findById(id);
        if (station.isEmpty()) throw new EntityNotFound("Station with id: " + id + " was not found");
        stationRepository.delete(station.get());
        return "Station with id " + id + " was successfully deleted";
    }
}
