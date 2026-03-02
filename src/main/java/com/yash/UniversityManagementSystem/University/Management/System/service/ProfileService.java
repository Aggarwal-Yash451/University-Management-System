package com.yash.UniversityManagementSystem.University.Management.System.service;


import com.yash.UniversityManagementSystem.University.Management.System.repositories.ProfileRepository;
import com.yash.UniversityManagementSystem.University.Management.System.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final StudentRepository studentRepository;





}
