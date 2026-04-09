package com.quickBite.event;

import com.quickBite.consumer.notification.NotificationEvent;
import com.quickBite.data.models.Notification;
import lombok.Data;

@Data
public class RegisterUserEvent implements NotificationEvent {

    private Notification notification;

    public RegisterUserEvent(Notification notification){
        this.notification = notification;
    }

}
