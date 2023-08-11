package br.com.carv.blog.controller;

import br.com.carv.blog.payload.request.LoginPostRequest;
import br.com.carv.blog.payload.response.JwtAuthorizationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Auth Endpoint", description = "Endpoint to authenticate users")
public interface AuthController {
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<JwtAuthorizationResponse> login(@RequestBody LoginPostRequest loginPostRequest);
}
