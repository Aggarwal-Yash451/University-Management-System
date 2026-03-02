package com.yash.UniversityManagementSystem.University.Management.System.service;

import com.yash.UniversityManagementSystem.University.Management.System.entity.Department;
import com.yash.UniversityManagementSystem.University.Management.System.entity.Professor;
import com.yash.UniversityManagementSystem.University.Management.System.repositories.DepartmentRepository;
import com.yash.UniversityManagementSystem.University.Management.System.repositories.ProfessorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ProfessorRepository professorRepository;

    @Transactional
    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

    @Transactional
    public void assignProfessorToDepartment(Long profId, Long departmentId){
        Professor professor = professorRepository.findById(profId).orElseThrow();
        Department department = departmentRepository.findById(departmentId).orElseThrow();

        department.addProfessor(professor);
    }

    @Transactional
    public void removeProfessor(Long profId, Long departmentId){
        Professor professor = professorRepository.findById(profId).orElseThrow();
        Department department = departmentRepository.findById(departmentId).orElseThrow();

        department.removeProfessor(professor);
    }

}
