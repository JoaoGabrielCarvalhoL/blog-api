package br.com.carv.blog.controller;

import br.com.carv.blog.payload.request.PostPostRequest;
import br.com.carv.blog.payload.request.PostPutRequest;
import br.com.carv.blog.payload.response.PostGetResponse;
import br.com.carv.blog.payload.response.PostResponse;
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

@Tag(name = "Post Endpoint", description = "Endpoint to managing posts")
@PreAuthorize("hasRole('ADMIN')")
public interface PostController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<EntityModel<PostResponse>> save(@RequestBody @Valid PostPostRequest postPostRequest);

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> update(@RequestBody @Valid PostPutRequest postPutRequest);

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> delete(@PathVariable("id") UUID id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Page<PostGetResponse>> findAll(Pageable pageable);

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PostGetResponse> findById(@PathVariable("id") UUID id);
}
