package com.sprints.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import com.sprints.library.service.ExcludedService;

@SpringBootApplication
@ComponentScan(
    basePackages = "com.sprints.library",
    includeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.sprints.library.(controller|service|config|repository).*"),
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {org.springframework.stereotype.Component.class})
    },
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = ExcludedService.class)
    }
)
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}
