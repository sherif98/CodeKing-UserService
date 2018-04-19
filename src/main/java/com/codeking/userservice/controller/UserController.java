package com.codeking.userservice.controller;

import com.codeking.userservice.controller.dto.NewUser;
import com.codeking.userservice.domain.User;
import com.codeking.userservice.exception.InvalidNewUserException;
import com.codeking.userservice.exception.UserNotFoundException;
import com.codeking.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("{userId}")
    public User getUserById(@PathVariable("userId") String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    @PostMapping
    public User addNewUser(@RequestBody @Valid NewUser newUser, Errors errors) {
        if (errors.hasErrors()) {
            throw new InvalidNewUserException(errors.getFieldErrors());
        }
        User user = User.builder()
                .userName(newUser.getUserName())
                .email(newUser.getEmail())
                .build();
        return userRepository.save(user);
    }
}
