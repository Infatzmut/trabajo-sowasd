package com.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinica.model.entity.HorarioAtencion;
import com.clinica.model.repository.HorarioAtencionRepository;
import com.clinica.service.HorarioAtencionService;

public class HorarioAtencionServiceImpl implements HorarioAtencionService{

	@Autowired
	private HorarioAtencionRepository horarioAtencion;
	@Override
	public List<HorarioAtencion> findAll() throws Exception {
		// TODO Auto-generated method stub
		return horarioAtencion.findAll();
	}

	@Override
	public Optional<HorarioAtencion> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return horarioAtencion.findById(id);
	}

	@Override
	public HorarioAtencion save(HorarioAtencion entity) throws Exception {
		// TODO Auto-generated method stub
		return horarioAtencion.save(entity);
	}

	@Override
	public HorarioAtencion update(HorarioAtencion entity) throws Exception {
		// TODO Auto-generated method stub
		return horarioAtencion.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		horarioAtencion.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		horarioAtencion.deleteAll();
	}

}
