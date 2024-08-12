package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name="product_has_batch")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductHasBatch {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    private Integer quantity;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
