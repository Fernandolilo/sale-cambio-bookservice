package br.com.sistempro.cambioservice.configuration;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(info = 
@Info(title = "Cambio Service API",
      version = "V1",
      description = "Documentation of Cambio Service API"))

public class OpenConfiguration {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components())
				.info(
						new io.swagger.v3.oas.models.info.Info()
						.title("Cambio Service API")
						.version("V1")
						.license( new License()
								.name("Apache 2.0")
								.url("http://springdoc.org")
						)
						
			);
		
	}
}
