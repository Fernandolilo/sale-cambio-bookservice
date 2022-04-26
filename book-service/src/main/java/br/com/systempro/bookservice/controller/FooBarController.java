package br.com.systempro.bookservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("book-service")
public class FooBarController {

	private Logger log = LoggerFactory.getLogger(FooBarController.class);

	@GetMapping("/foo-bar")
	public String fooBar() {
		
		//new RestTemplate().getForEntity("http://localhost:8085/foo-bar", String.class);

		return "Foo-Bar!!!";
	}

}
