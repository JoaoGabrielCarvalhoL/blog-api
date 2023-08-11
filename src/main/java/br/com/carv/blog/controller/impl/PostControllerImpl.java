package br.com.carv.blog.controller.impl;

import br.com.carv.blog.controller.PostController;
import br.com.carv.blog.payload.request.PostPostRequest;
import br.com.carv.blog.payload.request.PostPutRequest;
import br.com.carv.blog.payload.response.PostGetResponse;
import br.com.carv.blog.payload.response.PostResponse;
import br.com.carv.blog.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/post")
public class PostControllerImpl implements PostController {

    private final PostService postService;

    public PostControllerImpl(PostService postService) {
        this.postService = postService;
    }

    @Override
    public ResponseEntity<EntityModel<PostResponse>> save(PostPostRequest postPostRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.postService.save(postPostRequest));
    }

    @Override
    public ResponseEntity<Void> update(PostPutRequest postPutRequest) {
        this.postService.update(postPutRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        this.postService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Page<PostGetResponse>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.postService.findAll(pageable));
    }

    @Override
    public ResponseEntity<PostGetResponse> findById(UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.postService.findById(id));
    }
}
