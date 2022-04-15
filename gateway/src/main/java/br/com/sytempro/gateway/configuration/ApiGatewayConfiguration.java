package br.com.sytempro.gateway.configuration;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
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
		Function<PredicateSpec, Buildable<Route>>
		function = p -> p.path("/get")
						.filters(f -> f
								.addRequestHeader("Hello", "Word")
								.addRequestParameter("Hello", "Word"))
						
						.uri("http://httpbin.org:80");
		return builder.routes()
				.route(function)
				.build();
		

		
	}

}
