package com.codeking.userservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * exception thrown in case of invalid data entered when adding new user.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvalidNewUserException extends RuntimeException {

    private List<FieldError> fieldErrors;
}
