package com.project.spring.controller;

import com.project.spring.converter.UserConverter;
import com.project.spring.dto.user.UserRequest;
import com.project.spring.dto.user.UserResponse;
import com.project.spring.entity.User;
import com.project.spring.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User, Long, UserRequest, UserResponse> {
    private final UserService userService;
    private final UserConverter userConverter;

    public UserController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @Override
    public UserService getService() {
        return userService;
    }

    @Override
    public UserConverter getConverter() {
        return userConverter;
    }
}