package com.yash.UniversityManagementSystem.University.Management.System.repositories;

import com.yash.UniversityManagementSystem.University.Management.System.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}