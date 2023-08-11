package br.com.carv.blog.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.UUID;

public record PostPutRequest(
        @NotNull
        UUID id,
        @NotBlank(message = "The field title cannot be empty!")
        String title,
        @NotBlank(message = "The field description cannot be empty!")
        String description,
        @NotBlank(message = "The field content cannot be empty!")
        String content
) implements Serializable {
}
