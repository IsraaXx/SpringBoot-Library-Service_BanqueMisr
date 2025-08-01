package com.sprints.library;

import com.sprints.library.service.ExcludedService;
import com.sprints.library.service.GreetingService;
import com.sprints.library.config.LibraryConfig;
import com.sprints.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class LibraryApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		// Test passes if context loads successfully
	}

	@Test
	void includedBeansAreLoaded() {
		// Verify included beans are loaded
		assertTrue(applicationContext.containsBean("morningService"));
		assertTrue(applicationContext.containsBean("eveningService"));
		assertTrue(applicationContext.containsBean("libraryConfig"));
		assertTrue(applicationContext.containsBean("bookRepository"));
	}

	@Test
	void excludedServiceIsNotLoaded() {
		// Verify ExcludedService is not loaded
		assertFalse(applicationContext.containsBean("excludedService"));
		
		// Verify we cannot get the excluded service from context
		assertThrows(org.springframework.beans.factory.NoSuchBeanDefinitionException.class, () -> {
			applicationContext.getBean(ExcludedService.class);
		});
	}

}
