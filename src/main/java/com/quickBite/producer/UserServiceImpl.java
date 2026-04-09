package com.quickBite.producer;

import com.quickBite.config.EventPublisher;
import com.quickBite.data.models.Notification;
import com.quickBite.data.models.Status;
import com.quickBite.data.models.User;
import com.quickBite.data.repositories.UserRepository;
import com.quickBite.dtos.requests.RegisterUserRequest;
import com.quickBite.dtos.responses.RegisterUserResponse;
import com.quickBite.event.RegisterUserEvent;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServices{
    private final UserRepository userRepository;
    private final EventPublisher publisher;

    public UserServiceImpl(UserRepository userRepository, EventPublisher publisher) {
        this.userRepository = userRepository;
        this.publisher = publisher;
    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        User saved = userRepository.save(user);
        Notification notification = new Notification();
        notification.setSubject("Registration message");
        notification.setUserId(saved.getUserId());
        notification.setType("REGISTER");
        notification.setContent("You are welcome to our application");
        notification.setEmail(saved.getEmail());
        notification.setStatus(Status.REGISTERED);

        publisher.publish(new RegisterUserEvent(notification));
        return new RegisterUserResponse(saved.getName(), saved.getEmail(), saved.getPhone());
    }
}
