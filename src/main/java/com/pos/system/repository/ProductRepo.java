package com.pos.system.repository;

import com.pos.system.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product,String> {
}
