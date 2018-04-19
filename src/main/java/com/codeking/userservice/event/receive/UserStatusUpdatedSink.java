package com.codeking.userservice.event.receive;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Sink used by spring cloud stream to create listener for user status updated events.
 */
public interface UserStatusUpdatedSink {

    String INPUT = "userStatusUpdated";

    @Input("userStatusUpdated")
    SubscribableChannel userStatusUpdatedChannel();
}
