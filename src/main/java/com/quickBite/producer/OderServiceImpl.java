package com.quickBite.producer;

import com.quickBite.config.EventPublisher;
import com.quickBite.data.models.Notification;
import com.quickBite.data.models.Oder;
import com.quickBite.data.models.Status;
import com.quickBite.data.models.User;
import com.quickBite.data.repositories.NotificationRepository;
import com.quickBite.data.repositories.OderRepository;
import com.quickBite.data.repositories.UserRepository;
import com.quickBite.dtos.requests.OrderRequest;
import com.quickBite.event.OrderCreatedEvent;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OderServiceImpl implements OderService{

    private final OderRepository oderRepository;
    private final EventPublisher publisher;
    private final UserRepository userRepository;
    private final NotificationRepository notificationRepository;

    public OderServiceImpl(OderRepository oderRepository, EventPublisher publisher, UserRepository userRepository, NotificationRepository notificationRepository) {
        this.oderRepository = oderRepository;
        this.publisher = publisher;
        this.userRepository = userRepository;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void placeOder(OrderRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow();

        Oder oder = new Oder();
        oder.setItems(request.getItems());
        oder.setOderStatus(Status.PENDING);
        oder.setAddress(request.getDeliveryAddress());
        oder.setTimeStamp(LocalDateTime.now());
        oder.setUserId(user.getUserId());

        Notification notification = new Notification();
        notification.setContent("Your order is being processed right now");
        notification.setType("ODER");
        notification.setStatus(Status.PENDING);
        notification.setEmail(user.getEmail());
        notification.setUserId(user.getUserId());
        notification.setOderId(oder.getId());
        notification.setSubject("Processing orders");
        notificationRepository.save(notification);
        publisher.publish(new OrderCreatedEvent(notification));

    }
}
