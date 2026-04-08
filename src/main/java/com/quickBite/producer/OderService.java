package com.quickBite.producer;

import com.quickBite.dtos.requests.OderItemRequest;
import com.quickBite.dtos.requests.OrderRequest;
import com.quickBite.dtos.responses.OrderResponse;

public interface OderService {
    void placeOder(OrderRequest request);

}
