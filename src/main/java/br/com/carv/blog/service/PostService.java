package br.com.carv.blog.service;

import br.com.carv.blog.payload.request.PostPostRequest;
import br.com.carv.blog.payload.request.PostPutRequest;
import br.com.carv.blog.payload.response.PostGetResponse;
import br.com.carv.blog.payload.response.PostResponse;
import br.com.carv.blog.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import java.util.UUID;

public interface PostService {

    EntityModel<PostResponse> save(PostPostRequest postPostRequest);
    PostGetResponse findById(UUID uuid);
    Page<PostGetResponse> findAll(Pageable pageable);
    void update(PostPutRequest postPutRequest);
    void delete(UUID uuid);
    public Post findEntityById(UUID uuid);
}
