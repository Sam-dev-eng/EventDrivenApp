package com.quickBite.event;

import com.quickBite.consumer.notification.NotificationEvent;
import com.quickBite.data.models.Notification;
import com.quickBite.data.models.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PaymentProcessedEvent implements NotificationEvent {

    private Notification notification;

    public PaymentProcessedEvent(Notification notification){
        this.notification = notification;
    }
}
