package br.com.carv.blog.service;

import br.com.carv.blog.payload.request.UserPostRequest;
import br.com.carv.blog.payload.response.UserGetResponse;
import br.com.carv.blog.payload.response.UserResponse;
import org.springframework.hateoas.EntityModel;

import java.util.UUID;

public interface UserService {
    EntityModel<UserResponse> save(UserPostRequest userPostRequest);
    UserGetResponse findById(UUID uuid);
    void delete(UUID uuid);
}
