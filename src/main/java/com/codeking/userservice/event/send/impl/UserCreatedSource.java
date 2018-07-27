package com.codeking.userservice.event.send.impl;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface UserCreatedSource {

  @Output
  MessageChannel userCreated();
}
