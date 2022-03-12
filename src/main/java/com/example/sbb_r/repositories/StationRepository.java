package com.example.sbb_r.repositories;

import com.example.sbb_r.models.entities.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station,Long> {
    Station findStationByStationName(String stationName);
}
