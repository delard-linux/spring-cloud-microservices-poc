package org.delard.poc.springboot.micro.app.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.delard.poc.springboot.micro.app.item.models.Item;
import org.delard.poc.springboot.micro.app.item.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemServiceImpl implements IItemsService{

	@Autowired
	private RestTemplate clienteRest;
	
	// Devuelve una lista de Items (de futura factura o pedido) usando la lista completa de productos
	@Override
	public List<Item> findAll() {
		var productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
		return productos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	// Devuelve un Item (de futura factura o pedido) a partir del id de un producto y la cantidad 
	@Override
	public Item findById(Long id, Integer cantidad) {
		var pathVariables = new HashMap<String, String>(); 
		pathVariables.put("id", id.toString());
		var producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);
		return new Item(producto, cantidad);

	}

}
