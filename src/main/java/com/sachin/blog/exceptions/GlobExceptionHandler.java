package com.sachin.blog.exceptions;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundExeptionHandler(ResourceNotFoundException ex)
    {
        String message=ex.getMessage();
        return new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
    }
    //Method to handle Method Argument Not valid Exceptions raised by Bean Validation 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex)
    {
        Map<String , String> map=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName=((FieldError)error).getField();
            String message=error.getDefaultMessage();
            map.put(fieldName,message);
        });
        return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
    }

}
