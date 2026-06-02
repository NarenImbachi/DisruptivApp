package com.disruptiv.tikets.infra.out.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.disruptiv.tikets.domain.exception.BusinessException;
import com.disruptiv.tikets.domain.exception.ResourceNotFoundException;
import com.disruptiv.tikets.infra.input.dto.resp.ApiResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private String getRequestPath(WebRequest request) {
        return ((ServletWebRequest) request)
                .getRequest()
                .getRequestURI();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidationException(
            MethodArgumentNotValidException ex,
            WebRequest request) {

        FieldError fieldError =
                ex.getBindingResult()
                        .getFieldErrors()
                        .get(0);

        HttpStatus status = HttpStatus.BAD_REQUEST;

        return ResponseEntity.status(status)
                .body(ApiResponse.error(
                        fieldError.getDefaultMessage(),
                        "VALIDATION_ERROR",
                        status,
                        getRequestPath(request)));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleNotFoundException(
            ResourceNotFoundException ex,
            WebRequest request) {

        log.warn(
                "ResourceNotFoundException: {} at path {}",
                ex.getMessage(),
                getRequestPath(request));

        HttpStatus status = HttpStatus.NOT_FOUND;

        return ResponseEntity.status(status)
                .body(ApiResponse.error(
                        ex.getMessage(),
                        "RESOURCE_NOT_FOUND",
                        status,
                        getRequestPath(request)));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Object>> handleBusinessException(
            BusinessException ex,
            WebRequest request) {

        log.warn(
                "BusinessException: {} at path {}",
                ex.getMessage(),
                getRequestPath(request));

        HttpStatus status = HttpStatus.CONFLICT;

        return ResponseEntity.status(status)
                .body(ApiResponse.error(
                        ex.getMessage(),
                        "BUSINESS_RULE_VIOLATION",
                        status,
                        getRequestPath(request)));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGenericException(
            Exception ex,
            WebRequest request) {

        log.error(
                "Unexpected error at path {}",
                getRequestPath(request),
                ex);

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return ResponseEntity.status(status)
                .body(ApiResponse.error(
                        "Ocurrió un error inesperado.",
                        "INTERNAL_SERVER_ERROR",
                        status,
                        getRequestPath(request)));
    }
}
