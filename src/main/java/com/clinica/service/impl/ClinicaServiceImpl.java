package com.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.model.entity.Clinica;
import com.clinica.model.repository.ClinicaRepository;
import com.clinica.service.ClinicaService;
@Service
public class ClinicaServiceImpl implements ClinicaService {

	@Autowired
	private ClinicaRepository clinicaRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Clinica> findAll() throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Clinica> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.findById(id);
	}

	@Transactional
	@Override
	public Clinica save(Clinica entity) throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.save(entity);
	}

	@Transactional
	@Override
	public Clinica update(Clinica entity) throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		clinicaRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		clinicaRepository.deleteAll();
	}

}
