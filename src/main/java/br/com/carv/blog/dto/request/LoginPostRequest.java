package br.com.carv.blog.dto.request;

import java.io.Serializable;

public record LoginPostRequest(
        String username,
        String password
) implements Serializable {
}
