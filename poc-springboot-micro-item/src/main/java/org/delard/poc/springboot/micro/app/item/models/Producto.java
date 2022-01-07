package org.delard.poc.springboot.micro.app.item.models;

import java.io.Serializable;
import java.util.Date;

public class Producto implements Serializable{

	private static final long serialVersionUID = 8991260252190169040L;

	private Long id;
	
	private String nombre;
	
	private Double precio;
	
	private Date createAt;

	private Integer port;
	
	public Producto() {}

	public Producto(String nombre, Double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Producto [id=").append(id)
						.append(", nombre=").append(nombre)
						.append(", precio=").append(precio)
						.append(", createAt=").append(createAt)
						.append(", port=").append(port)
						.append("]");
		return builder.toString();
	}
	
}
