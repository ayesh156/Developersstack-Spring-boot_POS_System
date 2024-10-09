package com.pos.system.api;

import com.pos.system.dto.request.RequestProductDto;
import com.pos.system.dto.request.security.RequestUserDto;
import com.pos.system.service.ApplicationUserService;
import com.pos.system.service.ProductService;
import com.pos.system.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> create(@RequestBody RequestProductDto dto) throws SQLException {
        productService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"product created",null),
                HttpStatus.CREATED
        );
    }
}
