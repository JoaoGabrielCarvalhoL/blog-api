package br.com.carv.blog.controller.impl;

import br.com.carv.blog.controller.AuthController;
import br.com.carv.blog.payload.request.LoginPostRequest;
import br.com.carv.blog.payload.response.JwtAuthorizationResponse;
import br.com.carv.blog.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthControllerImpl implements AuthController {
    private final AuthService authService;
    public AuthControllerImpl(AuthService authService) {
        this.authService = authService;
    }
    @Override
    public ResponseEntity<JwtAuthorizationResponse> login(LoginPostRequest loginPostRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginPostRequest));
    }
}
