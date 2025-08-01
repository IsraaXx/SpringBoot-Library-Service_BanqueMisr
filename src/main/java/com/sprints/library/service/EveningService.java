package com.sprints.library.service;

import org.springframework.stereotype.Service;

@Service("evening")
public class EveningService implements GreetingService {

    @Override
    public String greeting() {
        return "Good Evening" ;
    }
}
