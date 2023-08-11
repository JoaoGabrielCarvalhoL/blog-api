package br.com.carv.blog.payload.response;

import java.io.Serializable;

public record JwtAuthorizationResponse(
        String token,
        String type
) implements Serializable {
}
