package com.pos.system.service;

import com.pos.system.dto.request.security.RequestUserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ApplicationUserService extends UserDetailsService {
    public void initializeUser();
    public void create(RequestUserDto dto);
}
