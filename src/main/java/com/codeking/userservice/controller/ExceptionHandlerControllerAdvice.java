package com.codeking.userservice.controller;

import com.codeking.userservice.controller.dto.ErrorResponse;
import com.codeking.userservice.exception.InvalidNewUserException;
import com.codeking.userservice.exception.UserNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * global exception handler controller advice.
 */
@RestControllerAdvice
@Log4j2
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse userNotFound(UserNotFoundException exc) {
        String userId = exc.getUserId();
        log.error("Can'find User with Id {}", userId);
        return ErrorResponse.builder()
                .errorMessages(Collections.singletonList(String.format("Can't find User with Id %s", userId)))
                .build();
    }


    @ExceptionHandler(InvalidNewUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse userNotFound(InvalidNewUserException exc) {
        List<String> errorMessages = exc.getFieldErrors().stream()
                .map(fieldError -> String.format("%s:%s", fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        log.error("Failed to add User {}", errorMessages);
        return ErrorResponse.builder()
                .errorMessages(errorMessages)
                .build();
    }
}
