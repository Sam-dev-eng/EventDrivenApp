package com.quickBite.consumer;

import com.quickBite.config.EventPublisher;
import com.quickBite.data.models.Notification;
import com.quickBite.data.models.Oder;
import com.quickBite.data.models.Status;
import com.quickBite.data.models.User;
import com.quickBite.data.repositories.NotificationRepository;
import com.quickBite.data.repositories.OderRepository;
import com.quickBite.data.repositories.UserRepository;
import com.quickBite.dtos.responses.OrderResponse;
import com.quickBite.event.OrderCreatedEvent;
import com.quickBite.event.PaymentProcessedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PaymentService {


    private final EventPublisher publisher;
    private final OderRepository orderRepository;
    private final NotificationRepository notificationRepository;

    public PaymentService(EventPublisher publisher, OderRepository orderRepository, UserRepository userRepository, NotificationRepository notificationRepository) {
        this.publisher = publisher;
        this.orderRepository = orderRepository;
        this.notificationRepository = notificationRepository;
    }

    @EventListener
    public void handle(OrderCreatedEvent event){
        Notification notification = event.getNotification();
        Optional<Oder> findOder = orderRepository.findById(notification.getOderId());
        if(findOder.isEmpty()) throw new RuntimeException("Oder not found");
        Oder oder = findOder.get();
        oder.setOderStatus(Status.PAYMENT_CONFIRMED);
        oder.setTotalAmount(120000);
        String type = "ODER";
        String content = "Thank you for your order we really appreciate";


        notification.setContent(content);
        notification.setType(type);
        notification.setStatus(Status.PAYMENT_CONFIRMED);
        notification.setSubject("Oder Confirmed");
        notificationRepository.save(notification);
        publisher.publish(new PaymentProcessedEvent(notification));
    }


}
