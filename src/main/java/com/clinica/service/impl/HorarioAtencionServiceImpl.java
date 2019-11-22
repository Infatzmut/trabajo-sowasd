package com.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.model.entity.HorarioAtencion;
import com.clinica.model.repository.HorarioAtencionRepository;
import com.clinica.service.HorarioAtencionService;

@Service
public class HorarioAtencionServiceImpl implements HorarioAtencionService{

	@Autowired
	private HorarioAtencionRepository horarioAtencion;
	
	@Transactional(readOnly = true)
	@Override
	public List<HorarioAtencion> findAll() throws Exception {
		// TODO Auto-generated method stub
		return horarioAtencion.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<HorarioAtencion> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return horarioAtencion.findById(id);
	}

	@Transactional
	@Override
	public HorarioAtencion save(HorarioAtencion entity) throws Exception {
		// TODO Auto-generated method stub
		return horarioAtencion.save(entity);
	}

	@Transactional
	@Override
	public HorarioAtencion update(HorarioAtencion entity) throws Exception {
		// TODO Auto-generated method stub
		return horarioAtencion.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		horarioAtencion.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		horarioAtencion.deleteAll();
	}

}
