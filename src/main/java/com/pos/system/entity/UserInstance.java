package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name="user_instance")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInstance {
    @Id
    @Column(name = "instance_id", length = 80)
    private String instanceId;

    @Column(name = "logged_date", columnDefinition = "DATETIME")
    private Date loggedDate;

    @Column(name = "instance_availability", columnDefinition = "TINYINT")
    private boolean instanceAvailability;

    @ManyToOne
    @JoinColumn(name = "application_user_id")
    private ApplicationUser applicationUser;
}
