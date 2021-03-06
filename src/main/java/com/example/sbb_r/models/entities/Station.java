package com.example.sbb_r.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "stations")
public class Station extends AbstractEntity implements Serializable {

    @Column(nullable = false)
    private String stationName;


    public Station(String stationName) {
        this.stationName = stationName;
    }

    public Station() {

    }
}
