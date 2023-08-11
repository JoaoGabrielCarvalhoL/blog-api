package br.com.carv.blog.service;

import br.com.carv.blog.payload.request.LoginPostRequest;
import br.com.carv.blog.payload.response.JwtAuthorizationResponse;

public interface AuthService {
    JwtAuthorizationResponse login(LoginPostRequest loginPostRequest);
}
