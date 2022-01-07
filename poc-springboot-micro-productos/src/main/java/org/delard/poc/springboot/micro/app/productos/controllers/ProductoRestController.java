package org.delard.poc.springboot.micro.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.delard.poc.springboot.micro.app.productos.models.entity.Producto;
import org.delard.poc.springboot.micro.app.productos.models.service.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProductoRestController {
	
	@Autowired
	private IProductoService productoService;
	
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/listar")
	public List<Producto> listar() {
		
		return productoService.findAll().stream().map(
				producto -> {
					producto.setPort(port);
					return producto;
				}).collect(Collectors.toList());
						
	}
	
	@GetMapping("/ver/{id}")
	public Producto detail(@PathVariable Long id) {
		
		var producto = productoService.findById(id);
		producto.setPort(port);
		return producto;
		
	}	
	
}