package br.com.carv.blog.mapper;

import br.com.carv.blog.payload.request.UserPostRequest;
import br.com.carv.blog.payload.response.UserGetResponse;
import br.com.carv.blog.payload.response.UserResponse;
import br.com.carv.blog.entity.User;
public interface UserMapper {
    UserResponse toUserResponse(User user);
    UserGetResponse toUserGetResponse(User user);
    User toUser(UserPostRequest userPostRequest);
}
