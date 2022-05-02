package br.com.systempro.bookservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("book-service")
public class FooBarController {

	private Logger logger = LoggerFactory.getLogger(FooBarController.class);

	@GetMapping("/foo-bar")
	@Retry(name = "foo-bar", fallbackMethod = "fallbackMethod")
	public String foobar() {
		logger.info("Request to foobar is receved!");
		var response = new RestTemplate().getForEntity("http://localhost:8085/foo-bar", String.class);
		// return "foo-bar!!!";

		return response.getBody();
	}
	
	public String fallbackMethod (Exception ex) {
		return "fallbackMethod foo-bar";
	}
}
