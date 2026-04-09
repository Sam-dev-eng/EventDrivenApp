package com.quickBite.dtos.requests;

import lombok.Data;

@Data
public class RegisterUserRequest {
    String name;
    String email;
    String phone;
}
