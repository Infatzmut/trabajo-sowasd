package com.clinica.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Column(length = 50)
	private String descripcion;
	
	@Column(nullable = false)
	private Float precio;

	@ManyToMany
	@JoinTable(
	name ="producto_proveedor",
	joinColumns = @JoinColumn(name="producto_id"),
	inverseJoinColumns = @JoinColumn(name="proveedor_id"))
	private List<Proveedor> proveedores;
	
	public Producto() {
		this.proveedores = new ArrayList<>();
	}
	
	public void addProveedor(Proveedor proveedor) {
		proveedor.addProducto(this);
		this.proveedores.add(proveedor);
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
}
