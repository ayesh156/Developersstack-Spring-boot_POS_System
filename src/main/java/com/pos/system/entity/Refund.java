package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name="refund")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Refund {
    @Id
    @Column(name = "refund_id")
    private String refundId;

    @Column(name = "refund_amount", precision = 2)
    private BigDecimal refundAmount;

    @Column(name = "refund_date", columnDefinition = "DATETIME")
    private Date refundDate;

    @ManyToOne
    @JoinColumn(name = "verified_person_id")
    private ApplicationUser verifiedPerson;

    @OneToOne
    @JoinColumn(name = "payment")
    private Payment payment;

    private String reason;
}
