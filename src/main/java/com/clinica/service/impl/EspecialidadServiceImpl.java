package com.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.clinica.model.entity.Especialidad;
import com.clinica.model.repository.EspecialidadRepository;
import com.clinica.service.EspecialidadService;
@Service
public class EspecialidadServiceImpl implements EspecialidadService{
	
	private EspecialidadRepository especialidadRepository;
	@Override
	public List<Especialidad> findAll() throws Exception {
		// TODO Auto-generated method stub
		return especialidadRepository.findAll();
	}

	@Override
	public Optional<Especialidad> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return especialidadRepository.findById(id);
	}

	@Override
	public Especialidad save(Especialidad entity) throws Exception {
		// TODO Auto-generated method stub
		return especialidadRepository.save(entity);
	}

	@Override
	public Especialidad update(Especialidad entity) throws Exception {
		// TODO Auto-generated method stub
		return especialidadRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		especialidadRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		especialidadRepository.deleteAll();
	}

}
