package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name="payment")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @Column
    private String payId;

    @OneToOne
    @JoinColumn(name = "customer_order")
    private CustomerOrder customerOrder;

    @Column(name = "amount", precision = 2)
    private BigDecimal amount;

    @Column(name = "payment_type", length = 80)
    private String paymentType;

    @Column(name = "paid_date", columnDefinition = "DATETIME")
    private Date paidDate;

    @Column(name = "balance", precision = 2)
    private BigDecimal balance;

    @Column(name = "Transferred_excess", precision = 2)
    private BigDecimal TransferredExcess;

    @OneToOne(mappedBy = "payment")
    private Payment payment;
}
