package com.project.vishal.library_sample;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.project.vishal.library_sample.controller.LibraryController;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LibrarySampleApplicationTests {

	@Autowired
	LibraryController libraryController;
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contexLoads() throws Exception {
		assertThat(libraryController).isNotNull();
	}

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/test",
				String.class)).contains("Hello from Library Controller");
	}

}
