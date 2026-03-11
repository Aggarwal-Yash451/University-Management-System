package com.yash.UniversityManagementSystem.University.Management.System.controller;

import com.yash.UniversityManagementSystem.University.Management.System.dto.StudentCreateDto;
import com.yash.UniversityManagementSystem.University.Management.System.dto.StudentResponseDto;
import com.yash.UniversityManagementSystem.University.Management.System.entity.Student;
import com.yash.UniversityManagementSystem.University.Management.System.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    private final ModelMapper modelMapper;

    @GetMapping("/{myId}")
    public StudentResponseDto getStudentById(@PathVariable Long myId) {
        Student student = studentService.getStudentById(myId);

        return modelMapper.map(student, StudentResponseDto.class);
    }

    @PostMapping
    public StudentResponseDto createStudent(@RequestBody StudentCreateDto studentCreateDto) {

        Student student = modelMapper.map(studentCreateDto, Student.class);

        Student newStudent = studentService.createNewStudent(student);

        return modelMapper.map(newStudent, StudentResponseDto.class);
    }

    @DeleteMapping("/{myId}")
    public void deleteStudent(@PathVariable Long myId) {
        studentService.deleteStudent(myId);
    }
}
