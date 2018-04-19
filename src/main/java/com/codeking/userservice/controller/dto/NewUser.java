package com.codeking.userservice.controller.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

/**
 * dto represents a new user to be added in the database.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewUser {

    @Length(min = 5, max = 20)
    private String userName;

    @Email
    private String email;

}
