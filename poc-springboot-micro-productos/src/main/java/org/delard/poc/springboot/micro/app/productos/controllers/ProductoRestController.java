package org.delard.poc.springboot.micro.app.productos.controllers;

import java.util.List;

import org.delard.poc.springboot.micro.app.productos.models.entity.Producto;
import org.delard.poc.springboot.micro.app.productos.models.service.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProductoRestController {
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> listar() {
		
		return productoService.findAll();
						
	}
	
	@GetMapping("/ver/{id}")
	public Producto detail(@PathVariable Long id) {
		
		return productoService.findById(id);
		
	}	
	
}