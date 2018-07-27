package com.codeking.userservice.event.send.api;

import com.codeking.userservice.event.dto.UserCreatedEvent;

public interface UserCreatedEventDispatcher {


  void dispatchUserCreatedEvent(UserCreatedEvent userCreatedEvent);
}
