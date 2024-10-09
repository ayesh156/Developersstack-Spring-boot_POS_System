package com.pos.system.service.impl;

import com.pos.system.dto.request.RequestProductDto;
import com.pos.system.entity.Product;
import com.pos.system.repository.ProductRepo;
import com.pos.system.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    @Override
    public void create(RequestProductDto dto) throws SQLException {
        productRepo.save(
                Product.builder()
                        .productId(UUID.randomUUID().toString())
                        .createdDate(new Date())
                        .price(dto.getPrice())
                        .name(dto.getName())
                        .description(new SerialBlob(dto.getDescription().getBytes()))
                        .lastUpdate(new Date())
                        .quantity(dto.getQuantity())
                        .build()
        );
    }
}
