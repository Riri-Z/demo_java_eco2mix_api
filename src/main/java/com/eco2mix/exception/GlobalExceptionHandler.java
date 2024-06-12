package com.eco2mix.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.eco2mix.energie.exception.EnergieDataNotFoundException;
import com.eco2mix.error.ErrorDetails;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(EnergieDataNotFoundException.class)
  public ResponseEntity<ErrorDetails> handleEnergieDataNotFoundException(EnergieDataNotFoundException ex,
      WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(
        new Date(),
        404,
        ex.getMessage());

    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex, WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(
        new Date(),
        HttpStatus.INSUFFICIENT_STORAGE.value(),
        ex.getMessage());

    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
