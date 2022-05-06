package br.com.sytempro.gateway.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class OpenConfiguration {


	@Bean
	@Lazy(false)
	public List<GroupedOpenApi> apis (SwaggerUiConfigParameters swaggerUiConfigParameters,
			RouteDefinitionLocator locator){
		//o .block é para manter o arquivo de doc da api, para garantir sua leiturua;
		var definitiosn = locator.getRouteDefinitions().collectList().block();
		
		definitiosn.stream().filter(
				routeDefinition -> routeDefinition.getId().matches(".*-service"))
				.forEach(routeDefinition -> {
					String name =  routeDefinition.getId();
					swaggerUiConfigParameters.addGroup(name);
					GroupedOpenApi.builder()
						.pathsToMatch("/" + name + "/**")
						.group(name).build();
					
				});
		return new ArrayList<>();
	}
}
