package br.com.carv.blog.payload.response;

import java.io.Serializable;
import java.util.UUID;
import java.util.List;


public record PostGetResponse(
        UUID id,
        String title,
        String description,
        String content,
        List<CommentGetResponse> comments
) implements Serializable {
}
