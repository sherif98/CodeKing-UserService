package com.codeking.userservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Set;

@Document(collection = "user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String userId;

    @Indexed(unique = true)
    private String username;

    @Email
    private String email;

    private int score;
    private Set<Badge> badges;
    private List<String> submissionIds;

}
