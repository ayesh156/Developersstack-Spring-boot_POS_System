package com.pos.system.service;

import com.pos.system.dto.request.RequestProductDto;

import java.sql.SQLException;

public interface ProductService {
    public void create(RequestProductDto dto) throws SQLException;
}
