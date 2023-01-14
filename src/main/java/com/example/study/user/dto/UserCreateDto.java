package com.example.study.user.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class UserCreateDto {
    @NotBlank
    private String firstName;
    private String lastName;
    private LocalDate birthday;
}
