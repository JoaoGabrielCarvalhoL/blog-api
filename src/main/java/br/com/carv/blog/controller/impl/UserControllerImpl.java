package br.com.carv.blog.controller.impl;

import br.com.carv.blog.controller.UserController;
import br.com.carv.blog.payload.request.UserPostRequest;
import br.com.carv.blog.payload.response.UserGetResponse;
import br.com.carv.blog.payload.response.UserResponse;
import br.com.carv.blog.service.UserService;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {
    private final UserService userService;
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<EntityModel<UserResponse>> save(UserPostRequest userPostRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.save(userPostRequest));
    }

    @Override
    public ResponseEntity<UserGetResponse> findById(UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.findById(id));
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        this.userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
