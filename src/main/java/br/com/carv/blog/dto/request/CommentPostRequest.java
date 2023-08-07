package br.com.carv.blog.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record CommentPostRequest(
        @NotBlank(message = "The field name cannot be empty.")
        String name,
        @Email
        String email,
        @NotBlank(message = "The field body cannot be empty.")
        String body
) implements Serializable {
}
