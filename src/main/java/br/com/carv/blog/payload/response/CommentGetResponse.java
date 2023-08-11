package br.com.carv.blog.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.UUID;

@JsonPropertyOrder(value = { "uuid", "name", "email", "body"})
public record CommentGetResponse(
        @JsonProperty("id")
        UUID uuid,
        String name,
        String email,
        String body
) implements Serializable {
}
