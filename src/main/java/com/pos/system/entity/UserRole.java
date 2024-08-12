package com.pos.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name="user_role")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @Id
    @Column(name = "role_id", length = 80)
    private String roleId;

    @Column(name = "role", unique = true, nullable = false)
    private String role;

    @ManyToMany(mappedBy = "userRoles")
    private Set<ApplicationUser> applicationUsers = new HashSet<>();
}
