package org.example.routineplanner.controller.exception_hanlders;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class GlobalExceptionHandler {

    // TODO sprawdzić jak działa
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(final EntityNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }
}
