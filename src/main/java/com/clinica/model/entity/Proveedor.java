package com.clinica.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(name="nombre", nullable = false, length =50)
	private String name;
	
	@Column(length = 60)
	private String direccion;
	
	@Column(length = 10)
	private String telefono;
	
	@Column(length = 30)
	private String email;
	
	@ManyToMany(mappedBy = "proveedores")
	private List<Clinica> clinicas;
	
	@ManyToMany(mappedBy = "proveedores")
	private List<Producto> productos;

	public Proveedor() {
		this.clinicas = new ArrayList<>();
		this.productos = new ArrayList<>();
	}
	
	public void addClinica(Clinica clinica) {
		this.clinicas.add(clinica);
	}
	
	public void addProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Clinica> getClinicas() {
		return clinicas;
	}

	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
}
