package com.pos.system.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtTokenUtil {
    private final SecretKey secretKey;


    public JwtTokenUtil(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public String getSubjectFromToken(String token){
        Claims body = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return body.getSubject();
    }
}
