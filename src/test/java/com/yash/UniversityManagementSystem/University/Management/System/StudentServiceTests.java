package com.yash.UniversityManagementSystem.University.Management.System;

import com.yash.UniversityManagementSystem.University.Management.System.entity.Course;
import com.yash.UniversityManagementSystem.University.Management.System.entity.Profile;
import com.yash.UniversityManagementSystem.University.Management.System.entity.Student;
import com.yash.UniversityManagementSystem.University.Management.System.service.CourseService;
import com.yash.UniversityManagementSystem.University.Management.System.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

import java.time.LocalDate;

@SpringBootTest
public class StudentServiceTests {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @Test
    public void studentProfileTest(){
        Profile profile = Profile.builder()
                .state("Haryana")
                .city("Faridabad")
                .postalCode("121002")
                .address("Old Faridabad")
                .build();

        studentService.assignProfileToStudent(profile, 1L);
    }

    @Test
    public void removeStudentProfile(){
        studentService.removeProfileOfStudent(1L);
    }

    @Test
    public void removeStudent(){
        studentService.deleteStudent(1L);
    }

    @Test
    public void enrollInACourse(){
        Course course = Course.builder().title("Springboot course").courseCode("ABC").credits(5).build();
        courseService.createCourse(course);
        studentService.enrollInACourse(1L, course.getId());
    }
}
