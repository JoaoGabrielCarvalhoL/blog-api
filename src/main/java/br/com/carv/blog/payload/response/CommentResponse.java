package br.com.carv.blog.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@JsonPropertyOrder(value = { "uuid", "name", "email", "body"})
public class CommentResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    @JsonProperty("id")
    private UUID uuid;
    private String name;
    private String email;
    private String body;
    public CommentResponse(UUID uuid, String name, String email, String body) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.body = body;
    }
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
