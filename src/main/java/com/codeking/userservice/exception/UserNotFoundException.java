package com.codeking.userservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * exception thrown in case of searching for a non existing user.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserNotFoundException extends RuntimeException {

    private String userId;

}
