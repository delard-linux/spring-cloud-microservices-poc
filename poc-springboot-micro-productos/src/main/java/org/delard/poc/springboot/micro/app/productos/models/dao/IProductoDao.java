package org.delard.poc.springboot.micro.app.productos.models.dao;

import org.delard.poc.springboot.micro.app.productos.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoDao extends CrudRepository<Producto, Long> {
	
}
