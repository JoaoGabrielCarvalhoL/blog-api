package br.com.carv.blog.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CommentPutRequest(
        @NotNull
        UUID uuid,
        @NotBlank(message = "The field name cannot be empty.")
        String name,
        @Email
        String email,
        @NotBlank(message = "The field body cannot be empty.")
        String body
) {
}
