package org.delard.poc.springboot.micro.app.productos.models.service;

import java.util.List;

import org.delard.poc.springboot.micro.app.productos.models.dao.IProductoDao;
import org.delard.poc.springboot.micro.app.productos.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	IProductoDao productoDao;

	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>)productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}
	
	
	
}
