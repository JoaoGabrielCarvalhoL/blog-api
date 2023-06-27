package br.com.carv.blog.exception.response;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ExceptionResponse(
        String title,
        Integer status,
        String details,
        LocalDateTime timestamp
) implements Serializable {
}
