package br.com.carv.blog.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.UUID;

public record UserGetResponse(
        UUID uuid,
        String name,
        String username,
        String email
) implements Serializable {
}
