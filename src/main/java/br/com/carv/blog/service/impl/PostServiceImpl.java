package br.com.carv.blog.service.impl;

import br.com.carv.blog.controller.impl.PostControllerImpl;
import br.com.carv.blog.dto.request.PostPostRequest;
import br.com.carv.blog.dto.request.PostPutRequest;
import br.com.carv.blog.dto.response.PostGetResponse;
import br.com.carv.blog.dto.response.PostResponse;
import br.com.carv.blog.entity.Post;
import br.com.carv.blog.exception.ResourceNotFoundException;
import br.com.carv.blog.mapper.PostMapper;
import br.com.carv.blog.repository.PostRepository;
import br.com.carv.blog.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final Logger logger = Logger.getLogger(PostServiceImpl.class.getSimpleName());

    private final PostMapper postMapper;
    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public EntityModel<PostResponse> save(PostPostRequest postPostRequest) {
        logger.info("Saving post into database.");
        Post saved = this.postRepository.save(postMapper.toPost(postPostRequest));
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PostControllerImpl.class)
                .findById(saved.getId())).withSelfRel();
        EntityModel<PostResponse> entityModel = EntityModel.of(postMapper.toPostResponse(saved));
        entityModel.add(link);
        return entityModel;
    }

    @Override
    public PostGetResponse findById(UUID uuid) {
        logger.info("Getting post by id: " + uuid);
        return this.postRepository.findById(uuid).map(postMapper::toPostGetResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found into database. Id: " + uuid));
    }

    @Override
    public Page<PostGetResponse> findAll(Pageable pageable) {
        logger.info("Getting all posts");
        List<PostGetResponse> collect = this.postRepository.findAll(pageable).stream()
                .map(postMapper::toPostGetResponse).toList();
        return new PageImpl<PostGetResponse>(collect, pageable, collect.size());
    }

    @Override
    public void update(PostPutRequest postPutRequest) {
        logger.info("Updating post");
        this.postRepository.saveAndFlush(postMapper.toPost(postPutRequest));
    }

    @Override
    public void delete(UUID uuid) {
        logger.info("Deleting post by id: " + uuid);
        this.postRepository.delete(findEntityById(uuid));
    }

    private Post findEntityById(UUID uuid) {
        return this.postRepository.findById(uuid).orElseThrow(() ->
                new ResourceNotFoundException("Resource not found into database. Id: " + uuid));
    }
}
