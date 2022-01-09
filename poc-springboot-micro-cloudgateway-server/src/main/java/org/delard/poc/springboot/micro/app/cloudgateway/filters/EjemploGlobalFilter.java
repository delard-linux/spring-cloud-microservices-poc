package org.delard.poc.springboot.micro.app.cloudgateway.filters;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class EjemploGlobalFilter implements GlobalFilter, Ordered{

	private static Logger log = LoggerFactory.getLogger(EjemploGlobalFilter.class);
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("Ejecutando filtro PRE");
		
		// se muta la cabecera y se le añade un atributo
		exchange.getRequest().mutate().headers(h -> h.add("token", "1234678"));
		
		//hasta chain.filter es el pre filter
		//lo que está dentro del then es el post filter
		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
						log.info("Ejecutando filtro POST");
						
						//se obtiene la cabecera del pre para pasarsela a la respuesta como header
						// en caso de que exista con el Optional
						Optional.ofNullable(exchange.getRequest().getHeaders().getFirst("token"))
									.ifPresent(
											valor ->
											exchange.getResponse().getHeaders().add("token", valor)
											);
						
						//añadimos una cookie
						exchange.getResponse().getCookies()
							.add("color", ResponseCookie.from("color","rojo").build());
						// se cambia el content typ a texto plano para hacer la prueba
						//exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
					}));
	}

	@Override
	public int getOrder() {
		// para que  no de error ya que -1 impide que se pueda escribir sobre la respuesta
		return 1;
	}

}
