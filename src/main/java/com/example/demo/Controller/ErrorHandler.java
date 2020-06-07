package com.example.demo.Controller;

import com.example.demo.Exception.CustomException;
import com.example.demo.Models.RestErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.RollbackException;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomException.class)
    public RestErrorResponse notFoundException(CustomException e) {
        return new RestErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public RestErrorResponse numberFormatException(NumberFormatException ex){
        return new RestErrorResponse(HttpStatus.BAD_REQUEST.value(),"ID int value required");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RollbackException.class)
    public RestErrorResponse RollbackException(RollbackException ex){
        return new RestErrorResponse(HttpStatus.BAD_REQUEST.value(),"Required fields rules");
    }

}