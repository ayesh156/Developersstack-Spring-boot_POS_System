package com.pos.system.api;

import com.google.zxing.WriterException;
import com.pos.system.dto.request.RequestProductDto;
import com.pos.system.service.BatchService;
import com.pos.system.service.ProductService;
import com.pos.system.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/batches")
public class BatchController {
    private final BatchService batchService;

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public ResponseEntity<StandardResponse> create(@RequestHeader(HttpHeaders.AUTHORIZATION) String tokenHeader) throws SQLException, IOException, WriterException {
        String token = tokenHeader.replace("Bearer ", "");
        batchService.create(token);
        return new ResponseEntity<>(
                new StandardResponse(201,"batch created",null),
                HttpStatus.CREATED
        );
    }
}
