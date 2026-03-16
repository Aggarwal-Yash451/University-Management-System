package com.yash.UniversityManagementSystem.University.Management.System.security;

import com.yash.UniversityManagementSystem.University.Management.System.dto.LoginRequestDto;
import com.yash.UniversityManagementSystem.University.Management.System.dto.LoginResponseDto;
import com.yash.UniversityManagementSystem.University.Management.System.dto.SignupDto;
import com.yash.UniversityManagementSystem.University.Management.System.dto.UserResponseDto;
import com.yash.UniversityManagementSystem.University.Management.System.entity.User;
import com.yash.UniversityManagementSystem.University.Management.System.enums.UserRoleEnum;
import com.yash.UniversityManagementSystem.University.Management.System.repositories.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;

    public UserResponseDto signup(SignupDto signupDto){
        User userDetails = userRepository.findByUsername(signupDto.getUsername()).orElseThrow();
        if(userDetails != null){
            throw new IllegalArgumentException("User already present please Login");
        }

        User savedUser = userRepository.save(
                User.builder()
                        .username(signupDto.getUsername())
                        .password(passwordEncoder.encode(signupDto.getPassword()))
                        .name(signupDto.getName())
                        .role(UserRoleEnum.USER)
                        .build()
        );

        return modelMapper.map(savedUser, UserResponseDto.class);
    }

    public LoginResponseDto login(LoginRequestDto loginDto){
        User user = userRepository.findByUsername(loginDto.getUsername()).orElseThrow();

        if(user == null){
            throw new IllegalArgumentException("User not found signup first");
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        User authUser = (User) authentication.getPrincipal();

        String token = authUtil.generateAccessToken(authUser);

        return new LoginResponseDto(authUser.getId(), token);
    }

}
