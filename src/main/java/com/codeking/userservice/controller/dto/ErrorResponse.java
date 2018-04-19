package com.codeking.userservice.controller.dto;

import lombok.*;

import java.util.List;

/**
 * used by controller to be returned in case of errors.
 *
 * @see com.codeking.userservice.exception.UserNotFoundException
 * @see com.codeking.userservice.exception.InvalidNewUserException
 * @see com.codeking.userservice.controller.ExceptionHandlerControllerAdvice
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private List<String> errorMessages;
}
