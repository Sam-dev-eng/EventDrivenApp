package com.quickBite.data.models;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
    @Id
    String userId;
    String name;
    String email;
    String phone;
}
