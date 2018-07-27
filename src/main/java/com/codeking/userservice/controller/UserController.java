package com.codeking.userservice.controller;

import com.codeking.userservice.controller.dto.NewUser;
import com.codeking.userservice.domain.User;
import com.codeking.userservice.event.dto.UserCreatedEvent;
import com.codeking.userservice.event.send.api.UserCreatedEventDispatcher;
import com.codeking.userservice.exception.InvalidNewUserException;
import com.codeking.userservice.exception.UserNotFoundException;
import com.codeking.userservice.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * user controller provides http end points to get user by ID and add new user.
 */
@RestController
@RequestMapping("/user")
@Log4j2
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserCreatedEventDispatcher userCreatedEventDispatcher;

  @GetMapping("{userId}")
  public User getUserById(@PathVariable("userId") String userId) {
    log.info("Searching for User with UserId: {}", userId);
    return userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException(userId));
  }


  @PostMapping
  public User addNewUser(@RequestBody @Valid NewUser newUser, Errors errors) {
    log.info("Trying to add new user {}", newUser);
    if (errors.hasErrors()) {
      throw new InvalidNewUserException(errors.getFieldErrors());
    }
    User user = User.builder()
            .userName(newUser.getUserName())
            .email(newUser.getEmail())
            .build();
    User savedUser = userRepository.save(user);
    userCreatedEventDispatcher.dispatchUserCreatedEvent(UserCreatedEvent
            .builder()
            .userId(savedUser.getUserId())
            .userName(savedUser.getUserName()).build());
    return savedUser;
  }
}
