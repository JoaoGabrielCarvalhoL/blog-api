package br.com.carv.blog.payload.request;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record PostPostRequest(
        @NotBlank(message = "The field title cannot be empty!")
        String title,
        @NotBlank(message = "The field description cannot be empty!")
        String description,
        @NotBlank(message = "The field content cannot be empty!")
        String content
) implements Serializable {
}
