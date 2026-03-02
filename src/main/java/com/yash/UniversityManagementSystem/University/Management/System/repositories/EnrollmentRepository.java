package com.yash.UniversityManagementSystem.University.Management.System.repositories;

import com.yash.UniversityManagementSystem.University.Management.System.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}