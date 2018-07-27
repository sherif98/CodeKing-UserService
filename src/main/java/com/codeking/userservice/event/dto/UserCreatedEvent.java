package com.codeking.userservice.event.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserCreatedEvent {

    private String userId;
    private String userName;
}
