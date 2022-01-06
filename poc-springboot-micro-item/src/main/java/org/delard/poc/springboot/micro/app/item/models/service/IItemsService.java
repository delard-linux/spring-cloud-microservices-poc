package org.delard.poc.springboot.micro.app.item.models.service;

import java.util.List;

import org.delard.poc.springboot.micro.app.item.models.Item;

public interface IItemsService {
	
	public List<Item> findAll();
	public Item findById(Long id, Integer cantidad);

}
