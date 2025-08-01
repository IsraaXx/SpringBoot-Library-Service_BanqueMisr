package com.sprints.library.service;

import org.springframework.stereotype.Service;

@Service("morning")
public class MorningService implements GreetingService {

    @Override
    public String greeting() {
        return "Good Morning" ;
    }
}
