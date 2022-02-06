package com.example.sbb_r.models.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Station extends AbstractEntity {
    private String stationName;


    public Station(String stationName) {
        this.stationName = stationName;
    }
}
