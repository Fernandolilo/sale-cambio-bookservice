package br.com.systempro.bookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

/*
 * @EnableFeignClients
 * Anotação para interfaces declarando que um cliente REST
 * com essa interface deve ser criado (por exemplo, para conexão automática em
 * outro componente). Se o SC LoadBalancer estiver disponível, ele será usado
 * para balancear a carga das solicitações de back-end e o balanceador de carga
 * pode ser configurado usando o mesmo nome (ou seja, valor) que o cliente
 * simulado.
 * 
 * Annotation for interfaces declaring that a REST client with that interface
 * should be created (e.g. for autowiring into another component). If SC
 * LoadBalancer is available it will be used to load balance the backend
 * requests, and the load balancer can be configured using the same name (i.e.
 * value) as the feign client.
 */

public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

}
