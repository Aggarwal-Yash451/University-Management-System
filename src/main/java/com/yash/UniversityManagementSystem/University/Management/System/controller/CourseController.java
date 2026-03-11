package com.yash.UniversityManagementSystem.University.Management.System.controller;

import com.yash.UniversityManagementSystem.University.Management.System.dto.CourseCreateDto;
import com.yash.UniversityManagementSystem.University.Management.System.dto.CourseResponseDto;
import com.yash.UniversityManagementSystem.University.Management.System.entity.Course;
import com.yash.UniversityManagementSystem.University.Management.System.repositories.CourseRepository;
import com.yash.UniversityManagementSystem.University.Management.System.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final ModelMapper modelMapper;

    @GetMapping("/{myId}")
    public CourseResponseDto getCourse(@PathVariable Long myId){
        Course course = courseService.getCourseById(myId);
        return modelMapper.map(course, CourseResponseDto.class);
    }

}
