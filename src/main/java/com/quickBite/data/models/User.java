package com.quickBite.data.models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("QuickBiteUsers")
public class User {
    @Id
    String userId;
    String name;
    String email;
    String phone;
}
