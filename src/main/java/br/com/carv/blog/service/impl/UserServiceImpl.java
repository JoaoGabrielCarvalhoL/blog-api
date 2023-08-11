package br.com.carv.blog.service.impl;

import br.com.carv.blog.controller.impl.UserControllerImpl;
import br.com.carv.blog.payload.request.UserPostRequest;
import br.com.carv.blog.payload.response.UserGetResponse;
import br.com.carv.blog.payload.response.UserResponse;
import br.com.carv.blog.entity.User;
import br.com.carv.blog.exception.ResourceNotFoundException;
import br.com.carv.blog.mapper.UserMapper;
import br.com.carv.blog.repository.UserRepository;
import br.com.carv.blog.service.UserService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public EntityModel<UserResponse> save(UserPostRequest userPostRequest) {
        User user = userMapper.toUser(userPostRequest);
        User saved = this.userRepository.save(user);
        EntityModel<UserResponse> entityModel = EntityModel.of(this.userMapper.toUserResponse(saved));
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserControllerImpl.class)
                .findById(saved.getUuid())).withSelfRel();
        entityModel.add(link);
        return entityModel;
    }

    @Override
    public UserGetResponse findById(UUID uuid) {
        return this.userRepository.findById(uuid)
                .map(userMapper::toUserGetResponse)
                .orElseThrow(() -> new ResourceNotFoundException("User not found into database. Id: " + uuid));
    }

    @Override
    public void delete(UUID uuid) {
        logger.info("Deleting user by id: " + uuid);
        this.userRepository.delete(findEntityById(uuid));
    }

    private User findEntityById(UUID uuid) {
        return this.userRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("User not found into database. Id: " + uuid));
    }
}
