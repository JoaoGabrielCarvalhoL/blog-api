package br.com.carv.blog.exception.response;

import java.time.LocalDateTime;

public record ExceptionValidationResponse(
        String title,
        Integer status,
        String details,
        String field,
        String message,
        LocalDateTime timestamp
) {
}
