package com.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.model.entity.Especialidad;
import com.clinica.model.repository.EspecialidadRepository;
import com.clinica.service.EspecialidadService;
@Service
public class EspecialidadServiceImpl implements EspecialidadService{
	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Especialidad> findAll() throws Exception {
		// TODO Auto-generated method stub
		return especialidadRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Especialidad> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return especialidadRepository.findById(id);
	}
	
	@Transactional
	@Override
	public Especialidad save(Especialidad entity) throws Exception {
		// TODO Auto-generated method stub
		return especialidadRepository.save(entity);
	}

	@Transactional
	@Override
	public Especialidad update(Especialidad entity) throws Exception {
		// TODO Auto-generated method stub
		return especialidadRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		especialidadRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		especialidadRepository.deleteAll();
	}

}
