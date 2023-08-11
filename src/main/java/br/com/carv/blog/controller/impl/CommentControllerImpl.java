package br.com.carv.blog.controller.impl;

import br.com.carv.blog.controller.CommentController;
import br.com.carv.blog.payload.request.CommentPostRequest;
import br.com.carv.blog.payload.request.CommentPutRequest;
import br.com.carv.blog.payload.response.CommentGetResponse;
import br.com.carv.blog.payload.response.CommentResponse;
import br.com.carv.blog.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/posts")
public class CommentControllerImpl implements CommentController {

    private final CommentService commentService;

    public CommentControllerImpl(CommentService commentService) {
        this.commentService = commentService;
    }
    @Override
    public ResponseEntity<EntityModel<CommentResponse>> save(CommentPostRequest commentPostRequest, UUID postId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.commentService.save(commentPostRequest, postId));
    }

    @Override
    public ResponseEntity<Void> update(CommentPutRequest commentPutRequest, UUID postId) {
        this.commentService.update(commentPutRequest, postId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        this.commentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Page<CommentGetResponse>> findAll(Pageable pageable, UUID postId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.commentService.findAll(pageable, postId));
    }

    @Override
    public ResponseEntity<CommentGetResponse> findById(UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.commentService.findById(id));
    }
}
