package com.codeking.userservice.event.dto;

import com.codeking.userservice.domain.Badge;
import lombok.*;

import java.util.Set;

/**
 * dto represents event when the user status is updated with new badges or new score.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserStatusUpdatedEvent {

    private String userId;
    private Set<Badge> userBadges;
    private int score;
}
