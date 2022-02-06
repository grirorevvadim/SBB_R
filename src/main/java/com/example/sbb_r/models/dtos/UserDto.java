package com.example.sbb_r.models.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class UserDto implements Serializable {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int wallet;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
}
