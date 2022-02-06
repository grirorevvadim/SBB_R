package com.example.sbb_r.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "users")
public class User extends AbstractEntity implements Serializable {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int wallet;
    private LocalDate birthdate;

}
