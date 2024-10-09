package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name="batch")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Batch {
    @Id
    @Column(name = "batch_id", length = 80)
    private String batchId;

    @Lob
    @Column(name = "barcode")
    private Blob barcode;

    @Column(name = "batch_number")
    private Long batchNumber;

    @Column(name = "created_date", columnDefinition = "DATETIME")
    private Date createdDate;

    @JoinColumn(name = "created_by")
    @ManyToOne
    private ApplicationUser createdBy;

    @OneToMany(mappedBy = "batch")
    private Set<ProductHasBatch> batchData = new HashSet<>();

    @OneToMany(mappedBy = "batch")
    private Set<OrderItem> orderItems = new HashSet<>();
}
