package com.codeking.userservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * entity represents user object.
 */
@Document(collection = "user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    private String userId;

    @Indexed(unique = true)
    private String userName;

    private String email;

    private int score;
    private Set<Badge> badges;

}
