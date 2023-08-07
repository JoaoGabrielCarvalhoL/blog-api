package br.com.carv.blog.mapper;

import br.com.carv.blog.dto.request.CommentPostRequest;
import br.com.carv.blog.dto.request.CommentPutRequest;
import br.com.carv.blog.dto.request.PostPostRequest;
import br.com.carv.blog.dto.request.PostPutRequest;
import br.com.carv.blog.dto.response.CommentGetResponse;
import br.com.carv.blog.dto.response.CommentResponse;
import br.com.carv.blog.dto.response.PostGetResponse;
import br.com.carv.blog.dto.response.PostResponse;
import br.com.carv.blog.entity.Comment;
import br.com.carv.blog.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment toComment(CommentPostRequest commentPostRequest);

    Comment toComment(CommentPutRequest commentPutRequest);

    CommentGetResponse toCommentGetResponse(Comment comment);

    CommentResponse toCommentResponse(Comment comment);
}
