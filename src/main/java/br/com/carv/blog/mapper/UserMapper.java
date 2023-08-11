package br.com.carv.blog.mapper;

import br.com.carv.blog.dto.request.UserPostRequest;
import br.com.carv.blog.dto.response.UserGetResponse;
import br.com.carv.blog.dto.response.UserResponse;
import br.com.carv.blog.entity.User;
public interface UserMapper {
    UserResponse toUserResponse(User user);
    UserGetResponse toUserGetResponse(User user);
    User toUser(UserPostRequest userPostRequest);
}
