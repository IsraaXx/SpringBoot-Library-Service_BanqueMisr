package com.sprints.library.controller;

import com.sprints.library.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingService morning;

    @Autowired
    public GreetingController(@Qualifier("morning") GreetingService morning){
        this.morning = morning;
    }

    @GetMapping("/morning")
    public String getMorningGreeting(){
        return morning.greeting();
    }

    private GreetingService evening;

    @Autowired
    public void setEvening(@Qualifier("evening") GreetingService evening){
        this.evening = evening;
    }

    @GetMapping("/evening")
    public String getEveningGreeting(){
        return evening.greeting();
    }

    @Autowired
    @Qualifier("morning")
    public GreetingService field;

    @GetMapping("/greeting")
    public String getFieldGreeting(){
        return  field.greeting();
    }
}
