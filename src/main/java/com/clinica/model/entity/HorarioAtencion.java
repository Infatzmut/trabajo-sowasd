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
@Table
public class HorarioAtencion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(nullable = false)
	private Integer horas;
	
	@Column(length = 12, nullable = false)
	private String tipo;

	@OneToMany(mappedBy="horarioAtencion",fetch = FetchType.LAZY)
	private List<Doctor> doctores;
	
	public HorarioAtencion() {
		this.doctores = new ArrayList<>();
	}
	
	public void addDoctor(Doctor doctor) {
		doctor.setHorarioAtencion(this);
		this.doctores.add(doctor);
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
