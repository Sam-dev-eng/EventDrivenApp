package com.quickBite.dtos.requests;

import com.quickBite.data.models.OderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    String userId;
    List<OderItem> items;
    String deliveryAddress;
}
