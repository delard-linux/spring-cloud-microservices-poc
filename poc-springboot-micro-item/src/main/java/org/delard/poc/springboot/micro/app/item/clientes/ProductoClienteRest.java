package org.delard.poc.springboot.micro.app.item.clientes;

import java.util.List;

import org.delard.poc.springboot.micro.app.item.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="servicio-productos",url="localhost:8001")
public interface ProductoClienteRest {
	
	@GetMapping("/listar")
	public List<Producto> listar();

	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id);

}
