package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name="product")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @Column(name = "product_id", length = 80)
    private String productId;
    private String name;

    @Lob
    @Column(name = "description")
    private Blob description;

    @Column(name = "price", precision = 2)
    private BigDecimal price;

    private int quantity;

    @Column(name="created_date", columnDefinition = "DATETIME")
    private Date createdDate;

    @Column(name="last_update", columnDefinition = "DATETIME")
    private Date lastUpdate;

    @OneToMany(mappedBy = "product")
    private Set<ProductHasBatch> batchData = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<OrderItem> orderItems = new HashSet<>();



}
