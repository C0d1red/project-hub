package ru.c0d1red.projecthub.adapter.rest.security.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
