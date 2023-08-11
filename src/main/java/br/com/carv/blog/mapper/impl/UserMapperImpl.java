package br.com.carv.blog.mapper.impl;

import br.com.carv.blog.payload.request.UserPostRequest;
import br.com.carv.blog.payload.response.UserGetResponse;
import br.com.carv.blog.payload.response.UserResponse;
import br.com.carv.blog.entity.Role;
import br.com.carv.blog.entity.User;
import br.com.carv.blog.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserMapperImpl implements UserMapper {
    private final PasswordEncoder passwordEncoder;
    public UserMapperImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserResponse toUserResponse(User user) {
        return new UserResponse(user.getUuid(), user.getName(),
                user.getUsername(), user.getEmail());
    }

    @Override
    public UserGetResponse toUserGetResponse(User user) {
        return new UserGetResponse(user.getUuid(), user.getName(),
                user.getUsername(), user.getEmail());
    }

    @Override
    public User toUser(UserPostRequest userPostRequest) {
        String encoded = this.passwordEncoder.encode(userPostRequest.password());
        Set<Role> authorities = new HashSet<Role>();
        authorities.add(new Role(userPostRequest.authority()));
        return new User(userPostRequest.name(), userPostRequest.username(),
                userPostRequest.email(), encoded, authorities, true);
    }
}
