package com.Narainox.blog.BlogAppAPI.Exception;

import com.Narainox.blog.BlogAppAPI.Payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex)
    {
         String massage=ex.getMessage();
         ApiResponse apiResponse=new ApiResponse(massage,false);
         return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethod(MethodArgumentNotValidException methodArgumentNotValidException)
    {
        Map<String,String> mp=new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error)->{
          String fieldName=  ((FieldError)error).getField();
          String message=error.getDefaultMessage();
          mp.put(fieldName,message);
        });
        return new ResponseEntity<>(mp,HttpStatus.BAD_REQUEST);
    }

}
