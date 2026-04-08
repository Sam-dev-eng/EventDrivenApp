package com.quickBite.data.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class Oder {
    String id;
    String userId;
    List<OderItem> items;
    long totalAmount;
    Status oderStatus;
    String address;
    LocalDateTime timeStamp;
}
