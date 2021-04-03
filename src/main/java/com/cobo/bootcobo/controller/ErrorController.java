package com.cobo.bootcobo.controller;

import com.cobo.bootcobo.exception.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorController {


    @ExceptionHandler(value = ConstraintViolationException.class)
    public String validationHandler (ConstraintViolationException constraintViolationException){

        return constraintViolationException.getMessage();
    }

    @ExceptionHandler(value = NotFoundException.class)
    public String notFound(NotFoundException notFoundException){

        return notFoundException.getMessage()==null?notFoundException.getMessage():"NOT FOUND";

    }


}
