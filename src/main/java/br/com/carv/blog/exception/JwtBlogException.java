package br.com.carv.blog.exception;

import org.springframework.http.HttpStatus;

public class JwtBlogException extends RuntimeException {

    private HttpStatus httpStatus;
    public JwtBlogException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
