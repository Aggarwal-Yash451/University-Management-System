package com.yash.UniversityManagementSystem.University.Management.System.service;

import com.yash.UniversityManagementSystem.University.Management.System.entity.Course;
import com.yash.UniversityManagementSystem.University.Management.System.repositories.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    @Transactional
    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    @Transactional
    public void deleteCourse(Long id){
        Course course = courseRepository.findById(id).orElseThrow();
        courseRepository.delete(course);
    }

}
