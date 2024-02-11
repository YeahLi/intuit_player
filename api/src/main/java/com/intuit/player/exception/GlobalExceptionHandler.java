package com.intuit.player.exception;

import com.intuit.player.exception.custom.ResourceNotFoundException;
import com.intuit.player.exception.dto.ErrorResponse;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global Exception Handler for REST API
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorResponse bindResourceNotFoundExceptions(RuntimeException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler({PropertyReferenceException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorResponse bindInvalidExceptions(RuntimeException e) {
        return new ErrorResponse(e.getMessage());
    }
}
