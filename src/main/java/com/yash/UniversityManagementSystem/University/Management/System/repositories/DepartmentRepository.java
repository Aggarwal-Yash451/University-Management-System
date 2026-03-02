package com.yash.UniversityManagementSystem.University.Management.System.repositories;

import com.yash.UniversityManagementSystem.University.Management.System.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}