package ru.c0d1red.projecthub.app.api.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindUserRequest {
    private String username;
}
