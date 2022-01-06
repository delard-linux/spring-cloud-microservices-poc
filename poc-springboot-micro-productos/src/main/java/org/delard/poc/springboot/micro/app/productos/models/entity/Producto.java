package org.delard.poc.springboot.micro.app.productos.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="productos")
public class Producto implements Serializable{

	private static final long serialVersionUID = 8991260252190169040L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String nombre;
	
	private Double precio;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	public Producto() {}

	public Producto(String nombre, Double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Producto [id=").append(id).append(", nombre=").append(nombre).append(", precio=").append(precio)
				.append(", createAt=").append(createAt).append("]");
		return builder.toString();
	}
	
}
