package org.delard.poc.springboot.micro.app.cloudgateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class EjemploGlobalFilter implements GlobalFilter{

	private static Logger log = LoggerFactory.getLogger(EjemploGlobalFilter.class);
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("Ejecutando filtro PRE");
		//hasta chain.filter es el pre filter
		//lo que está dentro del then es el post filter
		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
						log.info("Ejecutando filtro POST");
						//añadimos una cookie
						exchange.getResponse().getCookies()
							.add("color", ResponseCookie.from("color","rojo").build());
						// se cambia el content typ a texto plano para hacer la prueba
						exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
					}));
	}

}
