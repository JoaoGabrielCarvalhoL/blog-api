package br.com.carv.blog.mapper;

import br.com.carv.blog.payload.request.CommentPostRequest;
import br.com.carv.blog.payload.request.CommentPutRequest;
import br.com.carv.blog.payload.response.CommentGetResponse;
import br.com.carv.blog.payload.response.CommentResponse;
import br.com.carv.blog.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    Comment toComment(CommentPostRequest commentPostRequest);

    Comment toComment(CommentPutRequest commentPutRequest);

    CommentGetResponse toCommentGetResponse(Comment comment);

    CommentResponse toCommentResponse(Comment comment);
}
