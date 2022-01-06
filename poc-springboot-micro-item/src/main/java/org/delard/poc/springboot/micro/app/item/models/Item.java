package org.delard.poc.springboot.micro.app.item.models;

import java.io.Serializable;

public class Item implements Serializable{

	private static final long serialVersionUID = -5169900110127761263L;

	private Producto producto;
	
	private Integer cantidad;

	public Item() {}

	public Item(Producto producto, Integer cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [producto=").append(producto).append(", cantidad=").append(cantidad).append("]");
		return builder.toString();
	}
	
	public Double getTotal() {
		return producto.getPrecio() * cantidad.doubleValue();
	}

	
	
}
