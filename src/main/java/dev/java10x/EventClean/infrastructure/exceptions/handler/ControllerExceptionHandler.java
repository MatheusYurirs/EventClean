package dev.java10x.EventClean.infrastructure.exceptions.handler;

import dev.java10x.EventClean.infrastructure.exceptions.DuplicateEventException;
import dev.java10x.EventClean.infrastructure.exceptions.NotFoundEventException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String, String>> handlerDuplicateEventException(DuplicateEventException ex){

        Map<String, String> response = new HashMap<>();
        response.put("Error: ", ex.getMessage());
        response.put("Message: ","Please, Insert a valid hashId for you event and try again");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundEventException.class)
    public ResponseEntity<Map<String, String>> handlerNotFoundEventException(NotFoundEventException ex){
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", ex.getMessage());
        response.put("Message: ", "Event Not Found, please check the identifier again");
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
