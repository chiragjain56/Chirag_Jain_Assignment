package com.example.exception;


import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntryException.class)
    public ResponseEntity<MyErrorDetails> driverExceptionHandlr(EntryException ex, WebRequest req){
       MyErrorDetails myErr = new MyErrorDetails();
        myErr.setDateTime(LocalDateTime.now());
        myErr.setMessage(ex.getMessage());
        myErr.setDescription(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(myErr, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> methodArgumentNotValidExceptionHandlr(MethodArgumentNotValidException ex, WebRequest req){
        MyErrorDetails myErr = new MyErrorDetails();
        myErr.setDateTime(LocalDateTime.now());
        String error = "";
        int i = 1;
        for(ObjectError x: ex.getBindingResult().getAllErrors()){
            error += ( (i++) + " -> " + x.getDefaultMessage() + ";  ");
        }
        myErr.setMessage(error);
        myErr.setDescription(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(myErr, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<MyErrorDetails> notFoundExceptionHandlr(MyErrorDetails ex, WebRequest req){
        MyErrorDetails myErr = new MyErrorDetails();
        myErr.setDateTime(LocalDateTime.now());
        myErr.setMessage(ex.getMessage());
        myErr.setDescription(req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(myErr, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> exceptionHandlr(Exception ex, WebRequest req){
        MyErrorDetails myErr = new MyErrorDetails();
        myErr.setDateTime(LocalDateTime.now());
        myErr.setMessage(ex.getMessage());
        myErr.setDescription(req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(myErr, HttpStatus.BAD_REQUEST);
    }
}
