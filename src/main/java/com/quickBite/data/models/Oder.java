package com.quickBite.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Document("")
public class Oder {
    String id;
    String userId;
    List<OderItem> items;
    long totalAmount;
    Status oderStatus;
    String address;
    LocalDateTime timeStamp;
}
