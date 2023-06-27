package br.com.carv.blog.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.UUID;

public record PostGetResponse(
        UUID id,
        String title,
        String description,
        String content
) implements Serializable {
}
