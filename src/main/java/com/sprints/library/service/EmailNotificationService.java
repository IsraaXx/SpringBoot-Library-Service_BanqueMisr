package com.sprints.library.service;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmailNotificationService implements NotificationService {

    @Override
    public String send(String message) {
        return "Sending Email: " + message ;
    }
}
