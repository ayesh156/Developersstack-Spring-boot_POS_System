package com.pos.system.repository;

import com.pos.system.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface OrderItemRepo  extends JpaRepository<OrderItem,String> {
}
