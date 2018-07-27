package com.codeking.userservice.event.send.impl;

import com.codeking.userservice.event.dto.UserCreatedEvent;
import com.codeking.userservice.event.send.api.UserCreatedEventDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;


@EnableBinding(UserCreatedSource.class)
public class UserCreatedEventDispatcherImpl implements UserCreatedEventDispatcher {

  @Autowired
  private UserCreatedSource userCreatedSource;

  @Override
  public void dispatchUserCreatedEvent(UserCreatedEvent userCreatedEvent) {
    Message<UserCreatedEvent> userCreatedEventMessage = MessageBuilder.withPayload(userCreatedEvent).build();
    userCreatedSource.userCreated().send(userCreatedEventMessage);
  }
}
