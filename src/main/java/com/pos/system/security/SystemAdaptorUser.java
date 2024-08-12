package com.pos.system.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class SystemAdaptorUser implements UserDetails {
    private final String username;
    private final String password;
    private final boolean isAccountNonExpired;
    private final boolean isCredentialsNonExpired;
    private final boolean isCredentialsNonLocked;
    private final boolean isEnabled;
    private final Set<? extends GrantedAuthority> authorities;

    public SystemAdaptorUser(String username, String password, boolean isAccountNonExpired, boolean isCredentialsNonExpired, boolean isCredentialsNonLocked, boolean isEnabled, Set<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isCredentialsNonLocked = isCredentialsNonLocked;
        this.isEnabled = isEnabled;
        this.authorities = authorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
