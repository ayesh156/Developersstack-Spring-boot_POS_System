package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name="application_user")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationUser {
    @Id
    @Column(name = "user_id", length = 80)
    private String userId;

    private String username;
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "is_account_non_expired", columnDefinition = "TINYINT")
    private boolean isAccountNonExpired;

    @Column(name = "is_credentials_non_expired", columnDefinition = "TINYINT")
    private boolean isCredentialsNonExpired;

    @Column(name = "is_account_non_locked", columnDefinition = "TINYINT")
    private boolean isCredentialsNonLocked;

    @Column(name = "is_enabled", columnDefinition = "TINYINT")
    private boolean isEnabled;

    @ManyToMany
    @JoinTable(name = "user_has_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<UserRole> userRoles = new HashSet<>();

    @OneToMany(mappedBy = "createdBy")
    private Set<Batch> batch;

    @OneToMany(mappedBy = "verifiedPerson")
    private Set<Refund> refunds;

}
