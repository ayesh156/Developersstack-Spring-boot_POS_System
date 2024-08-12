package com.pos.system.service.impl;

import com.pos.system.entity.ApplicationUser;
import com.pos.system.entity.UserRole;
import com.pos.system.repository.ApplicationUserRepo;
import com.pos.system.security.SystemAdaptorUser;
import com.pos.system.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.pos.system.security.ApplicationUserRole.ADMIN;
import static com.pos.system.security.ApplicationUserRole.USER;

@Service
@RequiredArgsConstructor
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private final ApplicationUserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ApplicationUser> selectedUserObject = userRepo.findByUsername(username);

        if (selectedUserObject.isEmpty()){
            throw new RuntimeException(String.format("username not found %s", username));
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();

        for (UserRole ur: selectedUserObject.get().getUserRoles()){
            if(ur.getRole().equals("ADMIN")){
                grantedAuthorities.addAll(ADMIN.grantedAuthorities());
            }
            if(ur.getRole().equals("ADMIN")){
                grantedAuthorities.addAll(USER.grantedAuthorities());
            }
        }
        return new SystemAdaptorUser(
                selectedUserObject.get().getUsername(),
                selectedUserObject.get().getPassword(),
                selectedUserObject.get().isAccountNonExpired(),
                selectedUserObject.get().isCredentialsNonExpired(),
                selectedUserObject.get().isCredentialsNonLocked(),
                selectedUserObject.get().isEnabled(),
                grantedAuthorities
        );
    }
}
