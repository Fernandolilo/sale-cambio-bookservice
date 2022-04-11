package br.com.systempro.bookservice.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systempro.bookservice.model.Book;

@RestController
@RequestMapping("book-service")
public class BookController {

	/*
	 * URL Default para endpoint http://localhost:8000/book-service/1/BRL
	 * 
	 * private Environment environment; variavel que recupera as portas de serviço
	 */
	
	@Autowired
	private Environment environment;

	@GetMapping(value = "/{id}/{currency}")
	public Book findById(@PathVariable("id") Long id, @PathVariable("currency") String currency) {	

		//recuperando a porta do serviço
		var port = environment.getProperty("local.server.port");
		//passando dados mockados
		return new Book(1L, "Fernando", "Docker", new Date(), Double.valueOf(13.7), currency, port);
	}
}
