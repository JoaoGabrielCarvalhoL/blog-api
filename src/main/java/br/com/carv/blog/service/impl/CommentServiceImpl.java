package br.com.carv.blog.service.impl;

import br.com.carv.blog.controller.impl.CommentControllerImpl;
import br.com.carv.blog.payload.request.CommentPostRequest;
import br.com.carv.blog.payload.request.CommentPutRequest;
import br.com.carv.blog.payload.response.CommentGetResponse;
import br.com.carv.blog.payload.response.CommentResponse;
import br.com.carv.blog.entity.Comment;
import br.com.carv.blog.entity.Post;
import br.com.carv.blog.exception.ResourceNotFoundException;
import br.com.carv.blog.mapper.CommentMapper;
import br.com.carv.blog.repository.CommentRepository;
import br.com.carv.blog.service.CommentService;
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

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;
    private final CommentMapper commentMapper;
    private final Logger logger = Logger.getLogger(CommentServiceImpl.class.getName());

    public CommentServiceImpl(CommentRepository commentRepository, PostService postService, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.commentMapper = commentMapper;
    }

    @Override
    public EntityModel<CommentResponse> save(CommentPostRequest commentPostRequest, UUID postId) {
        logger.info("Saving comment into database.");
        Comment comment = this.commentMapper.toComment(commentPostRequest);
        Post post = this.postService.findEntityById(postId);
        comment.setPost(post);
        Comment saved = this.commentRepository.save(comment);
        EntityModel<CommentResponse> entityModel =
                EntityModel.of(this.commentMapper.toCommentResponse(saved));
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CommentControllerImpl.class)
                .findById(saved.getUuid())).withSelfRel();
        entityModel.add(link);
        return entityModel;
    }

    @Override
    public CommentGetResponse findById(UUID uuid) {
        logger.info("Getting comment by id: " + uuid);
        return this.commentRepository.findById(uuid)
                .map(commentMapper::toCommentGetResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found into database. Id: " + uuid));
    }

    @Override
    public Page<CommentGetResponse> findAll(Pageable pageable, UUID postId) {
        logger.info("Getting all comments from postId: " + postId);
        Post post = this.postService.findEntityById(postId);

        List<CommentGetResponse> list = this.commentRepository.findAll().stream()
                .filter(comment -> comment.getPost().getId().equals(postId))
                .map(commentMapper::toCommentGetResponse).toList();

        List<CommentGetResponse> collected = post.getComments().stream()
                .map(commentMapper::toCommentGetResponse).toList();
        return new PageImpl<CommentGetResponse>(collected, pageable, collected.size());
    }

    @Override
    public void update(CommentPutRequest commentPutRequest, UUID postId) {
        logger.info("Updating comment into database.");
        Post post = this.postService.findEntityById(postId);
        Comment comment = commentMapper.toComment(commentPutRequest);
        comment.setPost(post);
        this.commentRepository.save(comment);
    }

    @Override
    public void delete(UUID uuid) {
        logger.info("Deleting comment by id: " + uuid);
        this.commentRepository.delete(findEntityById(uuid));
    }

    private Comment findEntityById(UUID uuid) {
        return this.commentRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found into database. Id: " + uuid));
    }
}
