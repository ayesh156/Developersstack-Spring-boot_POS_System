package com.pos.system.api;

import com.pos.system.dto.request.security.RequestUserDto;
import com.pos.system.service.ApplicationUserService;
import com.pos.system.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final ApplicationUserService applicationUserService;

    @PostMapping("/signup")
    public ResponseEntity<StandardResponse> signup(@RequestBody RequestUserDto dto){
        applicationUserService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"user created",null),
                HttpStatus.CREATED
        );
    }
}
