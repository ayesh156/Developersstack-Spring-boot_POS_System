package com.pos.system.repository;

import com.pos.system.entity.ProductHasBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ProductHasBatchRepo extends JpaRepository<ProductHasBatch,String> {
}
