package com.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.model.entity.Clinica;
import com.clinica.model.repository.ClinicaRepository;
import com.clinica.service.ClinicaService;
@Service
public class ClinicaServiceImpl implements ClinicaService {

	@Autowired
	private ClinicaRepository clinicaRepository;
	@Override
	public List<Clinica> findAll() throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.findAll();
	}

	@Override
	public Optional<Clinica> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.findById(id);
	}

	@Override
	public Clinica save(Clinica entity) throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.save(entity);
	}

	@Override
	public Clinica update(Clinica entity) throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		clinicaRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		clinicaRepository.deleteAll();
	}

}
