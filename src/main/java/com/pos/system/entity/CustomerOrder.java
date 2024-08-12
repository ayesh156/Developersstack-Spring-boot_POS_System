package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name="customer_order")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrder {
    @Id
    @Column(name = "order_id", length = 80)
    private String orderId;

    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date orderDate;

    @Column(name = "customer", length = 80)
    private String customer;

    @Column(name = "total_amount", precision = 2)
    private BigDecimal totalAmount;

    @Column(name = "tax", precision = 2)
    private BigDecimal tax;

    @Column(name = "other_charges", precision = 2)
    private BigDecimal otherCharges;

    @Column(name = "status", columnDefinition = "TINYINT")
    private boolean status;

    @Column(name = "discount", precision = 2)
    private BigDecimal discount;

    @OneToMany(mappedBy = "customerOrder")
    private Set<OrderItem> orderItems = new HashSet<>();

    @OneToOne(mappedBy = "customerOrder")
    private Payment payment;
}
