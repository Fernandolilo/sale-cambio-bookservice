package br.com.systempro.bookservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systempro.bookservice.model.Book;
import br.com.systempro.bookservice.proxi.CambioProxi;
import br.com.systempro.bookservice.repositories.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {

	/*
	 * URL Default para endpoint http://localhost:8000/cambio-service/1/USD/BRL
	 * 
	 * private Environment environment; variavel que recupera as portas de serviço
	 */

	@Autowired
	private Environment environment;
	@Autowired
	private BookRepository repository;
	@Autowired
	private CambioProxi cambioProxi;


	/*
	 * @GetMapping(value = "/{id}/{currency}") public Book
	 * findById(@PathVariable("id") Long id, @PathVariable("currency") String
	 * currency) {
	 * 
	 * var book = repository.getById(id); if (book == null) { throw new
	 * RuntimeException("Book not found"); }
	 * 
	 * estão depois de recuperado o livro, vamos consumir o serviço atraves do rest
	 * template, o Json esta vindo formatado por Cambio.class, HashMap<String,
	 * String> params = new HashMap<>(); pegando este HashMap para passar os
	 * paramentros do RestTemplate, este será o amount, o from e to
	 * 
	 * HashMap<String, String> params = new HashMap<>();
	 * 
	 * params.put("amount", book.getPrice().toString()); params.put("from", "USD");
	 * params.put("to", currency);
	 * 
	 * var response = new RestTemplate()
	 * .getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}",
	 * Cambio.class, params);
	 * 
	 * var cambio = response.getBody(); // recuperando a porta do serviço var port =
	 * environment.getProperty("local.server.port"); book.setEnvitonment(port);
	 * //onde efetua a conversão book.setPrice(cambio.getConvertedValue()); return
	 * book; }
	 */

	@Operation(summary =  "Find a specific book  by yuor ID")
	@GetMapping(value = "/{id}/{currency}")
	public Book findById(@PathVariable("id") Long id, @PathVariable("currency") String currency) {

		var book = repository.getById(id);
		if (book == null) {
			throw new RuntimeException("Book not found");
		}

		/*
		 * no caso em vez de sempre fazer esta implementatação, atribuimos ela a um
		 * proxi, com o feign, importamos o proxi para dentro da class, agora sua nova
		 * declaração => var cambio = cambioProxi.getCambio(book.getPrice(), "USD",
		 * currency);
		 * HashMap<String, String> params = new HashMap<>();
		 * 
		 * params.put("amount", book.getPrice().toString()); params.put("from", "USD");
		 * params.put("to", currency);
		 * 
		 * var response = new RestTemplate()
		 * .getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}",
		 * Cambio.class, params);
		 * 
		 * var cambio = response.getBody()
		 */

		var cambio = cambioProxi.getCambio(book.getPrice(), "USD", currency);
		// recuperando a porta do serviço
		var port = environment.getProperty("local.server.port");
		book.setEnvitonment("Book port: " + port + " FEIGN" + " Cambio port: " + cambio.getEnvironment());
		// onde efetua a conversão
		book.setPrice(cambio.getConvertedValue());
		return book;
	}
}
