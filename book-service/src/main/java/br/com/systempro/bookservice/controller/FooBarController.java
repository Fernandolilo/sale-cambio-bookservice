package br.com.systempro.bookservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("book-service")
public class FooBarController {

	private Logger logger = LoggerFactory.getLogger(FooBarController.class);

	@GetMapping("/foo-bar")
	@Retry(name = "foo-bar", fallbackMethod = "fallbackMethod")
	@CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
	@RateLimiter(name = "default")
	@Bulkhead(name = "default")
	public String foobar() {
		logger.info("Request to foobar is receved!");
		/*
		 * var response = new
		 * RestTemplate().getForEntity("http://localhost:8085/foo-bar", String.class);
		 * // return "foo-bar!!!";
		 * 
		 * return response.getBody();
		 */
		return "Foo-bar";
	}
	
	public String fallbackMethod (Exception ex) {
		return "fallbackMethod foo-bar";
	}
}
