package com.clinica.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "clinica")
public class Clinica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Column(length = 50)
	private String direccion;
	
	private Integer telefono;
	
	@OneToMany(mappedBy = "clinica", fetch = FetchType.LAZY)
	private List<Doctor> doctores;
	
	@ManyToMany
	@JoinTable(
	name ="clinica_proveedor",
	joinColumns = @JoinColumn(name="clinica_id"),
	inverseJoinColumns = @JoinColumn(name="proveedor_id")
	)
	private List<Proveedor> proveedores;
	
	public Clinica() {
		this.proveedores = new ArrayList<>();
		this.doctores = new ArrayList<>();
	}
	
	public void addProveedor(Proveedor proveedor) {
		proveedor.addClinica(this);
		this.proveedores.add(proveedor);
	}
	
	public void addDoctor(Doctor doctor) {
		doctor.setClinica(this);
		this.doctores.add(doctor);
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public List<Doctor> getDoctores() {
		return doctores;
	}

	public void setDoctores(List<Doctor> doctores) {
		this.doctores = doctores;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	
	
	
}
