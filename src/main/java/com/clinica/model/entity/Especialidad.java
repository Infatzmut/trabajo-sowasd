package com.clinica.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="especialidad")
public class Especialidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(length = 60)
	private String descripcion;

	@OneToMany(mappedBy="especialidad", fetch = FetchType.LAZY)
	private List<Doctor> doctores;
	
	public Especialidad() {
		this.doctores = new ArrayList<>();
	}
	
	public void addDoctor(Doctor doctor) {
		doctor.setEspecialidad(this);
		this.doctores.add(doctor);
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
