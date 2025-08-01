package com.sprints.library.Controllers;


import com.sprints.library.service.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    private final NotificationService notificationService;
    private final NotificationService smsnotificationService;

    public NotificationController(NotificationService notificationService , @Qualifier("sms") NotificationService smsnotificationService) {
        this.notificationService = notificationService;
        this.smsnotificationService = smsnotificationService;
    }

    @GetMapping("/email")
    public String email() {
        return notificationService.send("Hello Spring !");
    }

    @GetMapping("/sms")
    public String sms() {
        return smsnotificationService.send("Hello Spring !");
    }

}
