package br.com.carv.blog.payload.response;

import java.io.Serializable;
import java.util.UUID;

public record UserGetResponse(
        UUID uuid,
        String name,
        String username,
        String email
) implements Serializable {
}
