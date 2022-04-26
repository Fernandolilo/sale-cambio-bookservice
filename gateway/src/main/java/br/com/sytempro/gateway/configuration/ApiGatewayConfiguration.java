package br.com.sytempro.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	/*
	 * "http://httpbin.orb:80" esta uri é padrão, é uma ferramenta de diagnostico
	 * que converte chamadas http em um Json como resposta com o diagnostico de sua
	 * api
	 */

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
								.filters(f -> f
										.addRequestHeader("Hello", "Word")
										.addRequestParameter("Hello", "Word"))
								
								.uri("http://httpbin.org:80"))
				.route(p -> p.path("/cambio-service/**")
				.uri("lb://cambio-service"))
				.route(p -> p.path("/book-service/**")
				.uri("lb://book-service"))
				.build();
		

		
	}

}
