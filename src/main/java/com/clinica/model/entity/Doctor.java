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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(name="nombre", length=50, nullable = false)
	private String name;
	
	@Column(length = 10, nullable = false)
	private String genero;
	
	@Column(length = 40)
	private String direccion;
	
	@Column
	private Integer telefono;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="horario_id")
	private HorarioAtencion horarioAtencion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinica_id")
	private Clinica clinica;
	
	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	private List<Cita> citas;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "especialidad")
	private Especialidad especialidad;
	
	public Doctor() {
		this.citas = new ArrayList<>();
	}
	
	public void addCitas(Cita cita) {
		cita.setDoctor(this);
		this.citas.add(cita);
	}
	
	public HorarioAtencion getHorarioAtencion() {
		return horarioAtencion;
	}

	public void setHorarioAtencion(HorarioAtencion horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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
	
}
