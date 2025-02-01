package com.example.customer_app.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CustomerDto {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
