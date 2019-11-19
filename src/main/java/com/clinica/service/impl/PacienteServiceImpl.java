package com.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.model.entity.Paciente;
import com.clinica.model.repository.PacienteRepository;
import com.clinica.service.PacienteService;
@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private PacienteRepository pacienteRepository;
	@Override
	public List<Paciente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return pacienteRepository.findAll();
	}

	@Override
	public Optional<Paciente> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return pacienteRepository.findById(id);
	}

	@Override
	public Paciente save(Paciente entity) throws Exception {
		// TODO Auto-generated method stub
		return pacienteRepository.save(entity);
	}

	@Override
	public Paciente update(Paciente entity) throws Exception {
		// TODO Auto-generated method stub
		return pacienteRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		pacienteRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		pacienteRepository.deleteAll();
	}

}
