package br.com.carv.blog.handler;

import br.com.carv.blog.exception.ResourceNotFoundException;
import br.com.carv.blog.exception.response.ExceptionResponse;
import br.com.carv.blog.exception.response.ExceptionValidationResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class BlogExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleException(Exception exception) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse("Bad Request", HttpStatus.BAD_REQUEST.value(),
                        exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AccessDeniedException.class)
    public final ResponseEntity<ExceptionResponse> handleAccessDeniedException(AccessDeniedException exception) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse("UNAUTHORIZED", HttpStatus.UNAUTHORIZED.value(),
                        exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.UNAUTHORIZED);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatusCode status, WebRequest request) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        String field = errors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String errorMessage = errors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        ExceptionValidationResponse exceptionValidationResponse =
                new ExceptionValidationResponse("Bad Request", HttpStatus.BAD_REQUEST.value(), "Check the field(s) error(s)",
                        field, errorMessage, LocalDateTime.now());
        return new ResponseEntity<>(exceptionValidationResponse, headers, status);
    }
}
