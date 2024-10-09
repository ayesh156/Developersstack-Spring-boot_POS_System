package com.pos.system.service.impl;

import com.pos.system.dto.request.security.RequestUserDto;
import com.pos.system.entity.ApplicationUser;
import com.pos.system.entity.UserRole;
import com.pos.system.exceptions.DuplicateEntryException;
import com.pos.system.exceptions.EntryNotFoundException;
import com.pos.system.repository.ApplicationUserRepo;
import com.pos.system.repository.UserRoleRepo;
import com.pos.system.security.SystemAdaptorUser;
import com.pos.system.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static com.pos.system.security.ApplicationUserRole.ADMIN;
import static com.pos.system.security.ApplicationUserRole.USER;

@Service
@RequiredArgsConstructor
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private final ApplicationUserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepo userRoleRepo;

    @Transactional
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
            if(ur.getRole().equals("USER")){
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

    @Override
    public void initializeUser() {
        Optional<ApplicationUser> selectedUserData = userRepo.findByUsername("ayesh.info@gmail.com");
        if(selectedUserData.isPresent()){
//            throw new DuplicateEntryException("");
            return;
        }

        Optional<UserRole> selectedRoleData = userRoleRepo.findByRole("ADMIN");
        if (selectedRoleData.isEmpty()){
            throw new EntryNotFoundException("Role not found");
        }

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(selectedRoleData.get());

        userRepo.save(ApplicationUser.builder()
                .userId(UUID.randomUUID().toString())
                .fullName("Ayesh Chathuranga")
                .userRoles(userRoles)
                .isAccountNonExpired(true)
                .isCredentialsNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .username("ayesh.info@gmail.com")
                .password(passwordEncoder.encode("1234"))
                .build());

    }

    @Override
    public void create(RequestUserDto dto) {
        Optional<ApplicationUser> selectedUserData = userRepo.findByUsername(dto.getUsername());
        if(selectedUserData.isPresent()){
            throw new DuplicateEntryException("Username was found");
        }

        Optional<UserRole> selectedRoleData = userRoleRepo.findByRole("USER");
        if (selectedRoleData.isEmpty()){
            throw new EntryNotFoundException("Role not found");
        }

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(selectedRoleData.get());

        userRepo.save(ApplicationUser.builder()
                .userId(UUID.randomUUID().toString())
                .fullName(dto.getFullName())
                .userRoles(userRoles)
                .isAccountNonExpired(true)
                .isCredentialsNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build());

    }
}
