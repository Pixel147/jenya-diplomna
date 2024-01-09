package com.project.spring.converter;

import com.project.spring.dto.user.UserRequest;
import com.project.spring.dto.user.UserResponse;
import com.project.spring.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserConverter extends BaseConverter<User, UserRequest, UserResponse>{
    @Override
    public User requestToEntity(UserRequest request) {
        User entity = new User();
        entity.setUsername(request.getUsername());
        entity.setPassword(request.getPassword());
        return entity;
    }

    @Override
    public UserResponse entityToResponse(User entity) {
        UserResponse response = new UserResponse();
        response.setId(entity.getId());
        response.setUsername(entity.getUsername());
        return response;
    }

    @Override
    public List<UserResponse> entityToResponse(List<User> entity) {
        return entity.stream().map(this::entityToResponse).toList();
    }
}
