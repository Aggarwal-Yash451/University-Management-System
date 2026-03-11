package com.yash.UniversityManagementSystem.University.Management.System.controller;

import com.yash.UniversityManagementSystem.University.Management.System.dto.CourseResponseDto;
import com.yash.UniversityManagementSystem.University.Management.System.dto.StudentResponseDto;
import com.yash.UniversityManagementSystem.University.Management.System.entity.Course;
import com.yash.UniversityManagementSystem.University.Management.System.entity.Student;
import com.yash.UniversityManagementSystem.University.Management.System.service.CourseService;
import com.yash.UniversityManagementSystem.University.Management.System.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final CourseService courseService;
    private final StudentService studentService;
    private final ModelMapper modelMapper;

    @PostMapping("/create-course")
    public CourseResponseDto createCourse(@RequestBody Course course){
        Course createdCourse = courseService.createCourse(course);
        return modelMapper.map(createdCourse, CourseResponseDto.class);
    }

    @DeleteMapping("/delete-course/{myId}")
    public void deleteCourse(@PathVariable Long myId){
        courseService.deleteCourse(myId);
    }

    @GetMapping("/get-all-students")
    public List<StudentResponseDto> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return students.stream()
                .map(student -> modelMapper.map(student, StudentResponseDto.class))
                .toList();
    }
}
