package br.com.carv.blog.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
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
