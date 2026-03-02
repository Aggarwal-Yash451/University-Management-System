package com.yash.UniversityManagementSystem.University.Management.System.repositories;

import com.yash.UniversityManagementSystem.University.Management.System.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}