package com.project.spring.controller;

import com.project.spring.converter.UserConverter;
import com.project.spring.dto.auth.AuthRequest;
import com.project.spring.dto.user.UserResponse;
import com.project.spring.entity.User;
import com.project.spring.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final UserConverter userConverter;

    public AuthController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody AuthRequest request){
        User user = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        UserResponse response = userConverter.entityToResponse(user);
        return ResponseEntity.ok(response);
    }
}
