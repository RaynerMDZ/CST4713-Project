package edu.citytech.cst.s23253396.cst4713project.security.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
    private String userId;
    private Name name;
    private String encryptedPassword;
    private Integer loginAttempts;
    private String[] roles;
    private boolean disabled;
}
