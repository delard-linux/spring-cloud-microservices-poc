package org.delard.poc.springboot.micro.app.item.controllers;

import java.util.List;

import org.delard.poc.springboot.micro.app.item.models.Item;
import org.delard.poc.springboot.micro.app.item.models.Producto;
import org.delard.poc.springboot.micro.app.item.models.service.IItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemRestController {
	
	@Autowired
	private CircuitBreakerFactory cbFactory;
	
	@Autowired
	@Qualifier("serviceFeign")
	//@Qualifier("serviceRestTemplate")
	private IItemsService itemService;

	Logger log = LoggerFactory.getLogger(ItemRestController.class); 
	
	@GetMapping("/listar")
	public List<Item> listar(
				@RequestParam(name="nombre", required = false) String nombre,
				@RequestHeader(name="token-request", required = false) String token
				) {
		
		log.info("Configuracion por filtro de fabrica: ");
		log.info(" nombre = {}", nombre);
		log.info(" token-request = {}", token);
		
		return itemService.findAll();
						
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detail(@PathVariable Long id, @PathVariable Integer cantidad ) {
		
		// de forma programatica en caso de error se llama a unmetodo alternativo
		return cbFactory.create("items")
				.run(() -> itemService.findById(id, cantidad),
						e-> metodoAlternativo(id, cantidad));
		
	}	

	public Item metodoAlternativo(Long id, Integer cantidad) {
		Item item = new Item();
		Producto producto = new Producto();
		
		item.setCantidad(cantidad);
		producto.setId(id);
		producto.setNombre("Camara Sony");
		producto.setPrecio(500.00);
		item.setProducto(producto);
		return item;
	}
	
}