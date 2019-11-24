package com.clinica.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.clinica.model.entity.Cita;

public interface CitaService extends CrudService<Cita, Integer>{
	
	List<Cita> findByPacienteCitas(Integer id);
	
	List<Cita> findByDoctorCitas(Integer id);
	
}
