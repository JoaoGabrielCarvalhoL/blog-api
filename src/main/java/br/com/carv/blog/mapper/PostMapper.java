package br.com.carv.blog.mapper;

import br.com.carv.blog.dto.request.PostPostRequest;
import br.com.carv.blog.dto.request.PostPutRequest;
import br.com.carv.blog.dto.response.PostGetResponse;
import br.com.carv.blog.dto.response.PostResponse;
import br.com.carv.blog.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post toPost(PostPostRequest postPostRequest);

    Post toPost(PostPutRequest postPutRequest);

    PostGetResponse toPostGetResponse(Post post);

    PostResponse toPostResponse(Post post);
}
