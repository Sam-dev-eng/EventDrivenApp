package com.quickBite.dtos.requests;

import lombok.Data;

@Data
public class OderItemRequest {
    String product;
    int quantity;
    long price;
}
