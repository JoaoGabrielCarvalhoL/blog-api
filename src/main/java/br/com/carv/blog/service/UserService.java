package br.com.carv.blog.service;

import br.com.carv.blog.dto.request.UserPostRequest;
import br.com.carv.blog.dto.response.UserGetResponse;
import br.com.carv.blog.dto.response.UserResponse;
import org.springframework.hateoas.EntityModel;

import java.util.UUID;

public interface UserService {
    EntityModel<UserResponse> save(UserPostRequest userPostRequest);
    UserGetResponse findById(UUID uuid);
    void delete(UUID uuid);
}
