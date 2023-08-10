package br.com.carv.blog.service.impl;

import br.com.carv.blog.dto.request.LoginPostRequest;
import br.com.carv.blog.repository.UserRepository;
import br.com.carv.blog.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final Logger logger = Logger.getLogger(AuthServiceImpl.class.getName());
    public AuthServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    @Override
    public String login(LoginPostRequest loginPostRequest) {
        logger.info("Authentication for username: " + loginPostRequest.username());
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginPostRequest.username(), loginPostRequest.password()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return "User logged-in successfully.";
    }
}
