package com.pos.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name="user_role")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRole {
    @Id
    @Column(name = "role_id", length = 80)
    private String roleId;

    @Column(name = "role", unique = true, nullable = false)
    private String role;

    @ManyToMany(mappedBy = "userRoles")
    private Set<ApplicationUser> applicationUsers = new HashSet<>();
}
