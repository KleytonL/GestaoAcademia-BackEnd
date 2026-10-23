package com.academia.api.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraint(ConstraintViolationException ex) {
        Map<String, String> erros = new HashMap<>();
        ex.getConstraintViolations().forEach(v ->
                erros.put(v.getPropertyPath().toString(), v.getMessage()));
        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity<Map<String, String>> handleTransaction(TransactionSystemException ex) {
        if (ex.getRootCause() instanceof ConstraintViolationException cve) {
            return handleConstraint(cve);
        }
        return ResponseEntity.internalServerError().build();
    }
}