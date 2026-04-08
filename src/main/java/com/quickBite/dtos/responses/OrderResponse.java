package com.quickBite.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponse {

    String oderId;
    String status;
    String message;
    String createdAt;
}
