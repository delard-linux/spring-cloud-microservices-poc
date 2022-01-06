package org.delard.poc.springboot.micro.app.productos.models.service;

import java.util.List;

import org.delard.poc.springboot.micro.app.productos.models.entity.Producto;


public interface IProductoService {
	
	public List<Producto> findAll();

	public Producto findById(Long id);

	
}
