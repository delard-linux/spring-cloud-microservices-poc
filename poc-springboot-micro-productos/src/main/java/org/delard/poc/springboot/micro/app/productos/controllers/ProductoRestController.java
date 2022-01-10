package org.delard.poc.springboot.micro.app.productos.controllers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.delard.poc.springboot.micro.app.productos.models.entity.Producto;
import org.delard.poc.springboot.micro.app.productos.models.service.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProductoRestController {
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private Environment env; 
	
	@GetMapping("/listar")
	public List<Producto> listar() {
		
		return productoService.findAll().stream().map(
				producto -> {
					producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
					return producto;
				}).toList();
						
	}
	
	@GetMapping("/ver/{id}")
	public Producto detail(@PathVariable Long id) throws InterruptedException{
		
		if (id.equals(10L)) 
			throw new IllegalStateException("Producto no encontrado");
		if (id.equals(7L)) 
			TimeUnit.SECONDS.sleep(5L);
		
		var producto = productoService.findById(id);
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return producto;
		
	}	
	
}