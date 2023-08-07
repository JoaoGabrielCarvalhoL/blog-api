package br.com.carv.blog.controller;

import br.com.carv.blog.dto.request.CommentPostRequest;
import br.com.carv.blog.dto.request.CommentPutRequest;
import br.com.carv.blog.dto.request.PostPostRequest;
import br.com.carv.blog.dto.request.PostPutRequest;
import br.com.carv.blog.dto.response.CommentGetResponse;
import br.com.carv.blog.dto.response.CommentResponse;
import br.com.carv.blog.dto.response.PostGetResponse;
import br.com.carv.blog.dto.response.PostResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Comment Endpoint", description = "Endpoint to managing comments")
@PreAuthorize("hasRole('ADMIN')")
public interface CommentController {

    @PostMapping("/{postId}/comment")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<EntityModel<CommentResponse>> save(@RequestBody @Valid CommentPostRequest commentPostRequest,
                                                      @PathVariable("postId") UUID postId);
    @PutMapping("/{postId}/comment")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> update(@RequestBody @Valid CommentPutRequest commentPutRequest,
                                @PathVariable("postId") UUID postId);
    @DeleteMapping(value = "/{id}/comment")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> delete(@PathVariable("id") UUID id);

    @GetMapping("/{postId}/comments")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Page<CommentGetResponse>> findAll(Pageable pageable, @PathVariable("postId") UUID postId);

    @GetMapping(value = "/{id}/comment")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CommentGetResponse> findById(@PathVariable("id") UUID id);
}
