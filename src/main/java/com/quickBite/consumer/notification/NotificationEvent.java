package com.quickBite.consumer.notification;

import com.quickBite.data.models.Notification;
import com.quickBite.data.models.Status;

public interface NotificationEvent {
    Notification getNotification();

}
