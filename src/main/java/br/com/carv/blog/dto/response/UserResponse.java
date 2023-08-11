package br.com.carv.blog.dto.response;

import java.io.Serializable;
import java.util.UUID;

public class UserResponse implements Serializable {
    private UUID uuid;
    private String name;
    private String username;
    private String email;

    public UserResponse() {}

    public UserResponse(UUID uuid, String name, String username, String email) {
        this.uuid = uuid;
        this.name = name;
        this.username = username;
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
