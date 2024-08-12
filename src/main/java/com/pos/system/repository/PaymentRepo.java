package com.pos.system.repository;

import com.pos.system.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface PaymentRepo extends JpaRepository<Payment,String> {
}
