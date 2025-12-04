package com.jipenaflor.cinema_room_service.exception;

import com.jipenaflor.cinema_room_service.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({InvalidPurchaseException.class, InvalidTokenException.class})
    public ResponseEntity<ErrorDTO> handleInvalidPurchaseAndRefundRequest(RuntimeException e) {
        ErrorDTO error = new ErrorDTO(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidManagerPasswordException.class})
    public ResponseEntity<ErrorDTO> handleInvalidManagerPassword(InvalidManagerPasswordException e) {
        ErrorDTO error = new ErrorDTO(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
}