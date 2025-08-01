package com.sprints.library.controller;

import com.sprints.library.config.LibraryConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    private LibraryConfig library;
    public ConfigController(LibraryConfig library) {
        this.library = library;
    }

    @GetMapping("/config")
        public String config() {
            return "Library: " + library.getName() + " | Mode: " + library.getMode();
        }
}
