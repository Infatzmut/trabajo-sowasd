package com.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.model.entity.ResultadoLaboratorio;
import com.clinica.model.repository.ResultadoLaboratorioRepository;
import com.clinica.service.ResultadoLaboratorioService;

@Service
public class ResultadoLaboratorioServiceImpl implements ResultadoLaboratorioService{

	@Autowired
	private ResultadoLaboratorioRepository resultadoLaboratorio;
	
	@Transactional(readOnly = true)
	@Override
	public List<ResultadoLaboratorio> findAll() throws Exception {
		// TODO Auto-generated method stub
		return resultadoLaboratorio.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<ResultadoLaboratorio> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return resultadoLaboratorio.findById(id);
	}

	@Transactional
	@Override
	public ResultadoLaboratorio save(ResultadoLaboratorio entity) throws Exception {
		// TODO Auto-generated method stub
		return resultadoLaboratorio.save(entity);
	}

	@Transactional
	@Override
	public ResultadoLaboratorio update(ResultadoLaboratorio entity) throws Exception {
		// TODO Auto-generated method stub
		return resultadoLaboratorio.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		resultadoLaboratorio.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		resultadoLaboratorio.deleteAll();
	}

}
