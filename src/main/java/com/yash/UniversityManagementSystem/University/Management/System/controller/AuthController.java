package com.yash.UniversityManagementSystem.University.Management.System.controller;

import com.yash.UniversityManagementSystem.University.Management.System.dto.LoginRequestDto;
import com.yash.UniversityManagementSystem.University.Management.System.dto.LoginResponseDto;
import com.yash.UniversityManagementSystem.University.Management.System.dto.SignupDto;
import com.yash.UniversityManagementSystem.University.Management.System.dto.UserResponseDto;
import com.yash.UniversityManagementSystem.University.Management.System.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public UserResponseDto signUp(@RequestBody SignupDto signupDto){
        return authService.signup(signupDto);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        return authService.login(loginRequestDto);
    }
}
