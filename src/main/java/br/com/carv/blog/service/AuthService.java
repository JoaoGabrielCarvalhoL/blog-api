package br.com.carv.blog.service;

import br.com.carv.blog.dto.request.LoginPostRequest;

public interface AuthService {

    String login(LoginPostRequest loginPostRequest);
}
