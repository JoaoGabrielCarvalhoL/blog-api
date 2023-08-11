package br.com.carv.blog.service;

import br.com.carv.blog.payload.request.CommentPostRequest;
import br.com.carv.blog.payload.request.CommentPutRequest;
import br.com.carv.blog.payload.response.CommentGetResponse;
import br.com.carv.blog.payload.response.CommentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import java.util.UUID;

public interface CommentService {

    EntityModel<CommentResponse> save(CommentPostRequest commentPostRequest, UUID postId);
    CommentGetResponse findById(UUID uuid);
    Page<CommentGetResponse> findAll(Pageable pageable, UUID postId);
    void update(CommentPutRequest commentPutRequest, UUID postId);
    void delete(UUID uuid);
}
