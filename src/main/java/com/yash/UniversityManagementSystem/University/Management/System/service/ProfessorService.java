package com.yash.UniversityManagementSystem.University.Management.System.service;

import com.yash.UniversityManagementSystem.University.Management.System.entity.Professor;
import com.yash.UniversityManagementSystem.University.Management.System.repositories.ProfessorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Transactional
    public Professor createProfessor(Professor professor){
        return professorRepository.save(professor);
    }
}
