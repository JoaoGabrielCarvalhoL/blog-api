package br.com.carv.blog.payload.request;

import java.io.Serializable;

public record LoginPostRequest(
        String username,
        String password
) implements Serializable {
}
