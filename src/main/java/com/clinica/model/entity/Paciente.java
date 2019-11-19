package com.clinica.model.entity;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name="paciente")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Column
	private Date nacimiento;
	
	@Column(length = 10)
	private Integer telefono;
	
	@Column(length = 12, nullable = false)
	private String genero;
	
	@OneToMany(mappedBy = "paciente",fetch = FetchType.LAZY)
	private List<Cita> citas;
	
	@OneToMany(mappedBy = "paciente",fetch = FetchType.LAZY)
	private List<ResultadoLaboratorio> resultadosLaboratorio;
	
	public Paciente() {
		this.citas = new ArrayList<>();
		this.resultadosLaboratorio = new ArrayList<>();
	}
	
	public void addCita(Cita cita) {
		cita.setPaciente(this);
		this.citas.add(cita);
	}
	
	public void addResultadoLaboratorio(ResultadoLaboratorio resultado) {
		resultado.setPaciente(this);
		this.resultadosLaboratorio.add(resultado);
	}
	
	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public List<ResultadoLaboratorio> getResultadosLaboratorio() {
		return resultadosLaboratorio;
	}

	public void setResultadosLaboratorio(List<ResultadoLaboratorio> resultadosLaboratorio) {
		this.resultadosLaboratorio = resultadosLaboratorio;
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

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
}
