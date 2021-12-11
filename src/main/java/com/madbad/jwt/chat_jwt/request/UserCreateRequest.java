package com.madbad.jwt.chat_jwt.request;

import lombok.Data;
@Data
public class UserCreateRequest {
    private String username;
    private String password;
}
