package com.quickBite.event;

import com.quickBite.consumer.notification.NotificationEvent;
import com.quickBite.data.models.Notification;
import lombok.Data;

@Data
public class OrderCreatedEvent implements NotificationEvent {
    Notification notification;

    public OrderCreatedEvent(Notification notification){
        this.notification = notification;
    }


}
