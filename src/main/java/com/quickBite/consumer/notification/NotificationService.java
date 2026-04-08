package com.quickBite.consumer.notification;

import com.quickBite.data.models.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {


    private final JavaMailSender mailSender;

    public NotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @EventListener
    @Async
    public void sendNotification(NotificationEvent event){
        Notification notification = event.getNotification();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(notification.getEmail());
        message.setSubject(notification.getSubject());
        message.setText(notification.getContent());
        mailSender.send(message);
    }


   }
