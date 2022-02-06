package com.example.sbb_r.models.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User extends AbstractEntity {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int wallet;
    private LocalDate birthdate;

}
