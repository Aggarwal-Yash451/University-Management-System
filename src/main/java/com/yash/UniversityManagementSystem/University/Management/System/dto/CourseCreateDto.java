package com.yash.UniversityManagementSystem.University.Management.System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseCreateDto {

    String courseCode;

    String title;

    int credits;
}
