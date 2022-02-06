package com.example.sbb_r.models.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "users")
public class User extends AbstractEntity implements Serializable {
    @Column(length = 50)
    private String firstname;
    @Column(length = 100)
    private String lastname;
    @Column(unique = true, length = 150)
    private String email;

    private String emailVerificationToken;

    @Column
    private Boolean emailVerificationStatus;

    @Column
    private String password;

    @Column
    private int wallet;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

}
