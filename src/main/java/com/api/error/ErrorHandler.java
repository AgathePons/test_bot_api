package com.api.error;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    /**
     * Override default handling of validation errors
     * @param exception
     * @param headers
     * @param status
     * @param request
     * @return
     */
    public ResponseEntity<Object> handleMethodArgumentNotValid (
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request
    ) {
        return ResponseEntity.status(status).body("Data not valid");
    }

    @ExceptionHandler(NoDataFoundError.class)
    public ResponseEntity<ErrorMessage> handleNoDataFoundError(
            Exception exception, WebRequest request
    ){
        return responseEntity(HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler(BadRequestError.class)
    public ResponseEntity<ErrorMessage> handleBadRequest(
            Exception exception, WebRequest request
    ) {
        return responseEntity(HttpStatus.BAD_REQUEST, exception);
    }

    /**
     * Build an HTTP response with:
     * - an HTTP status
     * - the error message from the source exception
     * @param httpStatus
     * @param exception
     * @return response
     */
    private static ResponseEntity<ErrorMessage> responseEntity(HttpStatus httpStatus, Exception exception) {
        return ResponseEntity.status(httpStatus)
                .body(
                        ErrorMessage.builder()
                                .status(httpStatus.value())
                                .error(exception.getMessage())
                                .build()
                );
    }
}

