package com.example.party2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class MemberRequest {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
