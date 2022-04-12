package br.com.sistempro.cambioservice.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistempro.cambioservice.model.Cambio;
import br.com.sistempro.cambioservice.repositories.CambioRepository;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

	/*
	 * URL do endpoint http://localhost:8000/cambio-service/5/USD/BRL 
	 */

	/*
	 * para iniciar o load balance, no dashBoard, clicar com o direito, duplicate
	 * App, open config, em arguents passar o paramentro -Dserver.port=8001 como por
	 * padrão estou usando a porta 8000, sempre a mais proxima
	 */

	@Autowired
	private Environment environment;
	
	@Autowired
	private CambioRepository repository;

	@GetMapping(value = "/{amount}/{from}/{to}")
	public Cambio getCambio(
			@PathVariable("amount") BigDecimal amount,
			@PathVariable("from") String from,
			@PathVariable("to") String to) {
		
		var cambio = repository.findByFromAndTo(from, to);
		if (cambio == null) {
			throw new RuntimeException("Currency Unsupported");
		}
		//pega a porta de servico
		var port = environment.getProperty("local.server.port");
		
		//fazendo a conversão
		BigDecimal conversionFactor = cambio.getConvetionFactor();
		BigDecimal convertedValue = conversionFactor.multiply(amount);
		
		cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
		cambio.setEnvironment(port);
		return cambio;
	}

}
