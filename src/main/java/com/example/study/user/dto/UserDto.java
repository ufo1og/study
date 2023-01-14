package com.example.study.user.dto;



import lombok.Data;

import java.time.LocalDate;


@Data
public class UserDto {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;
    private final LocalDate registrationDate;
}
