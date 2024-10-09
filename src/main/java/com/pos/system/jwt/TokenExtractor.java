package com.pos.system.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenExtractor {
    private final JwtTokenUtil jwtTokenUtil;

    public String getSubject(String token){
        return jwtTokenUtil.getSubjectFromToken(token);
    }
}
