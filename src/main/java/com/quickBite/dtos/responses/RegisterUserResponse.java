package com.quickBite.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterUserResponse {
    String name;
    String email;
    String phone;
}
