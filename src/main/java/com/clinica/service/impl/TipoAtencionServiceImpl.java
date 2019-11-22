package com.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.model.entity.TipoAtencion;
import com.clinica.model.repository.TipoAtencionRepository;
import com.clinica.service.TipoAtencionService;
@Service
public class TipoAtencionServiceImpl implements TipoAtencionService{
	
	@Autowired
	private TipoAtencionRepository tipoAtencionRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<TipoAtencion> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tipoAtencionRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<TipoAtencion> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return tipoAtencionRepository.findById(id);
	}

	@Transactional
	@Override
	public TipoAtencion save(TipoAtencion entity) throws Exception {
		// TODO Auto-generated method stub
		return tipoAtencionRepository.save(entity);
	}

	@Transactional
	@Override
	public TipoAtencion update(TipoAtencion entity) throws Exception {
		// TODO Auto-generated method stub
		return tipoAtencionRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		tipoAtencionRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		tipoAtencionRepository.deleteAll();
	}

}
