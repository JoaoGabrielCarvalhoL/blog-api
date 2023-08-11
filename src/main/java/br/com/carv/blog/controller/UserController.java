package br.com.carv.blog.controller;

import br.com.carv.blog.dto.request.UserPostRequest;
import br.com.carv.blog.dto.response.UserGetResponse;
import br.com.carv.blog.dto.response.UserResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "User Endpoint", description = "Endpoint to managing users.")
@PreAuthorize("hasRole('ADMIN')")
public interface UserController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<EntityModel<UserResponse>> save(@RequestBody @Valid UserPostRequest userPostRequest);
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<UserGetResponse> findById(@PathVariable("id") UUID id);
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> delete(@PathVariable("id") UUID id);
}
