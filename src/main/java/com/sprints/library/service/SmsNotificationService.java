package com.sprints.library.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("sms")
public class SmsNotificationService implements NotificationService {

    @Override
    public String send(String message) {
        return "Sending SMS: " + message;
    }
}
