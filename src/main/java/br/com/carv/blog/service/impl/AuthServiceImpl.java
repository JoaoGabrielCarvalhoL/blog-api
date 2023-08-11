package br.com.carv.blog.service.impl;

import br.com.carv.blog.payload.request.LoginPostRequest;
import br.com.carv.blog.payload.response.JwtAuthorizationResponse;
import br.com.carv.blog.security.JwtTokenProvider;
import br.com.carv.blog.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final Logger logger = Logger.getLogger(AuthServiceImpl.class.getName());
    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @Override
    public JwtAuthorizationResponse login(LoginPostRequest loginPostRequest) {
        logger.info("Authentication for username: " + loginPostRequest.username());
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginPostRequest.username(), loginPostRequest.password()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = this.jwtTokenProvider.generateToken(authenticate);
        return new JwtAuthorizationResponse(token, "Bearer ");
    }
}
