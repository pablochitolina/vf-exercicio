package org.pablochitolina.exercicio.rest.configuration;

import lombok.extern.slf4j.Slf4j;
import org.pablochitolina.exercicio.domain.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler {
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<String> customHandleNotFound(Exception ex, WebRequest request) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<List<String>> customHandleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {

        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map( fe -> fe.getDefaultMessage()).collect(Collectors.toList());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
