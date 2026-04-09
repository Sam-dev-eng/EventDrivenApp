package com.quickBite.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Notifications")
public class Notification {
    @Id
    String id;
    String email;
    String oderId;
    String userId;
    String type;
    String content;
    Status status;
    String subject;
}
