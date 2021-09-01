package com.realbizgames.demo.hazelcast.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;

    private String createdAt;
    private String updatedAt;
}
