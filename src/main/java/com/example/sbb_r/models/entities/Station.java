package com.example.sbb_r.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Station {
    private String stationName;


    public Station(String stationName) {
        this.stationName = stationName;
    }
}
