package com.quickBite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {


    private final ApplicationEventPublisher publisher;

    public EventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish(Object event){
        publisher.publishEvent(event);
    }
}
