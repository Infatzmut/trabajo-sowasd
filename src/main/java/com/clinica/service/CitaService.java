package com.clinica.service;

import java.util.List;

import com.clinica.model.entity.Cita;

public interface CitaService extends CrudService<Cita, Integer>{
	List<Cita> findByPacienteId(int id) throws Exception; 
}
