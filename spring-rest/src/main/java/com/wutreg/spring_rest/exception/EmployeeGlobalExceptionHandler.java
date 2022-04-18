package com.wutreg.spring_rest.exception;

import com.wutreg.spring_rest.dto.EmployeeExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeExceptionDTO> handleException(EmployeeNotFoundException exception) {
        EmployeeExceptionDTO dto = new EmployeeExceptionDTO();
        dto.setErrorMessage(exception.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeExceptionDTO> handleException(Exception exception) {
        EmployeeExceptionDTO dto = new EmployeeExceptionDTO();
        dto.setErrorMessage(exception.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
