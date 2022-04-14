package br.com.systempro.bookservice.proxi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import response.Cambio;

@FeignClient(name = "cambio-service")

/*
 * @FeignClient(name = "cambio-service", url = "localhost:8000") name =
 * cambio-service => o name do serviço que estamos consumindo, a URL do serviço
 * url = "localhost:8000"
 */
public interface CambioProxi {
	/*
	 * desta forma ele ja sabe; buscar os dadso de forma dinamica, sabendo abistrair
	 * tudo que for necessarios dentro da aplicação, não havendo a necessidade do RestTemplate
	 */

	@GetMapping(value = "/cambio-service/{amount}/{from}/{to}")
	public Cambio getCambio(
			@PathVariable("amount") Double amount,
			@PathVariable("from") String from,
			@PathVariable("to") String to);
	
}
