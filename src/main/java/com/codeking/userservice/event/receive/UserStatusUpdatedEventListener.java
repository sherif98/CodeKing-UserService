package com.codeking.userservice.event.receive;


import com.codeking.userservice.event.dto.UserStatusUpdatedEvent;
import com.codeking.userservice.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * handler for user status updated events.
 */
@EnableBinding(UserStatusUpdatedSink.class)
@Log4j2
public class UserStatusUpdatedEventListener {

    @Autowired
    private UserRepository userRepository;

    @StreamListener(UserStatusUpdatedSink.INPUT)
    public void handleUserStatusUpdatedEvent(UserStatusUpdatedEvent userStatusUpdatedEvent) {
        log.info("received user status updated event {}", userStatusUpdatedEvent);
        String userId = userStatusUpdatedEvent.getUserId();
        userRepository.findById(userId).ifPresent(user -> {
            log.info("user is found processing event {}", userStatusUpdatedEvent);
            user.setScore(userStatusUpdatedEvent.getScore());
            user.setBadges(userStatusUpdatedEvent.getUserBadges());
            userRepository.save(user);
        });
    }

}
