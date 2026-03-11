package com.yash.UniversityManagementSystem.University.Management.System.repositories;

import com.yash.UniversityManagementSystem.University.Management.System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByUsername(String username);
}
