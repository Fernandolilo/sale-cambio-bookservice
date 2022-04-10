package br.com.sistempro.cambioservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistempro.cambioservice.model.Cambio;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

	/*
	 * URL do endpoint http://localhost:8000/cambio-service/5/USD/BRL expor a porta
	 * com o environment
	 */

	/*
	 * para iniciar o load balance, no dashBoard, clicar com o direito, duplicate
	 * App, open config, em arguents passar o paramentro -Dserver.port=8001 como por
	 * padrão estou usando a porta 8000, sempre a mais proxima
	 */

	@Autowired
	private Environment environment;

	@GetMapping(value = "/{amount}/{from}/{to}")
	public Cambio getCambio(@PathVariable("amount") BigDecimal amount, @PathVariable("from") String from,
			@PathVariable("to") String to) {
		// pergar a porta com o environment
		var port = environment.getProperty("local.server.port");
		return new Cambio(1L, "USD", "BRL", BigDecimal.ONE, BigDecimal.ONE, port);
	}

}
