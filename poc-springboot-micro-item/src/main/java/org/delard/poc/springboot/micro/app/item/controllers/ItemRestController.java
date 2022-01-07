package org.delard.poc.springboot.micro.app.item.controllers;

import java.util.List;

import org.delard.poc.springboot.micro.app.item.models.Item;
import org.delard.poc.springboot.micro.app.item.models.service.IItemsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ItemRestController {
	
	@Autowired
	@Qualifier("serviceFeign")
	private IItemsService itemService;
	
	@GetMapping("/listar")
	public List<Item> listar() {
		
		return itemService.findAll();
						
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detail(@PathVariable Long id, @PathVariable Integer cantidad ) {
		
		return itemService.findById(id, cantidad);
		
	}	
	
}