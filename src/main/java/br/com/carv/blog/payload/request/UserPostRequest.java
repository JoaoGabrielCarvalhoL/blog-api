package br.com.carv.blog.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record UserPostRequest(
        @NotBlank(message = "The field name cannot be empty.")
        String name,
        @NotBlank(message = "The field username cannot be empty and must be unique.")
        String username,
        @Email(message = "The field email must be unique.")
        String email,
        @NotBlank(message = "The field password cannot be empty.")
        String password,
        @NotBlank(message = "The field authority cannot be empty.")
        String authority)
implements Serializable {
}
