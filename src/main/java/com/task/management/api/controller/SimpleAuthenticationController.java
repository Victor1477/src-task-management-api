package com.task.management.api.controller;

import com.task.management.api.dto.TokenResponseDTO;
import com.task.management.api.entity.User;
import com.task.management.api.service.SimpleAuthenticationService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authenticate")
public class SimpleAuthenticationController {
    @Resource
    SimpleAuthenticationService simpleAuthenticationService;

    @PostMapping
    public ResponseEntity login(@RequestBody User user) {
        TokenResponseDTO token = this.simpleAuthenticationService.authenticate(user);

        if (token == null) {
            return ResponseEntity.status(401).build();
        }

        return ResponseEntity.ok(token);
    }
}
