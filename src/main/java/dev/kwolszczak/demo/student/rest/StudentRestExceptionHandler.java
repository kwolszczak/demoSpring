package dev.kwolszczak.demo.student.rest;

import dev.kwolszczak.demo.student.entity.StudentErrorResponse;
import dev.kwolszczak.demo.student.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//global handling of errors
@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        //StudentErrorResponse
        var error = new StudentErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                System.currentTimeMillis());

        //responseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlerAllExceptions(Exception exception) {
        var error = new StudentErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Bad request",
                System.currentTimeMillis());

        //responseEntity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
