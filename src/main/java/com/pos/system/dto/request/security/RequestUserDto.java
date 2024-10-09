package com.pos.system.dto.request.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
public class RequestUserDto {
    private String username;
    private String password;
    private String fullName;
}
