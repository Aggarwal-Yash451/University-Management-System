package com.yash.UniversityManagementSystem.University.Management.System.security;

import com.yash.UniversityManagementSystem.University.Management.System.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class AuthUtil {

    @Value("${jwt_secret}")
    private String jwtSecretKey;

    public SecretKey getScretKey(){
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccessToken(User user){
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("userid", user.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 10*60*1000))
                .signWith(getScretKey())
                .compact();
    }






}
