package org.delard.poc.springboot.micro.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.delard.poc.springboot.micro.app.item.clientes.ProductoClienteRest;
import org.delard.poc.springboot.micro.app.item.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements IItemsService {

	@Autowired
	ProductoClienteRest productoClienteRestFeign;

	// Devuelve una lista de Items (de futura factura o pedido) usando la lista completa de productos
	@Override
	public List<Item> findAll() {
		return productoClienteRestFeign.listar()
				.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	// Devuelve un Item (de futura factura o pedido) a partir del id de un producto y la cantidad 
	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(productoClienteRestFeign.detalle(id), cantidad);
	}
	
}
