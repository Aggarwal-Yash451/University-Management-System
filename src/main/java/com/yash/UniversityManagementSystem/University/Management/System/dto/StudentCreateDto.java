package com.yash.UniversityManagementSystem.University.Management.System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateDto {
    private String rollNumber;

    private String name;

    private String email;

    private String phoneNumber;

    private LocalDate dateOfBirth;
}
