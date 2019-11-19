package com.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinica.model.entity.Proveedor;
import com.clinica.model.repository.ProveedorRepository;
import com.clinica.service.ProveedorService;

public class ProveedorServiceImpl implements ProveedorService {
	@Autowired
	private ProveedorRepository proveedorRepository;
	@Override
	public List<Proveedor> findAll() throws Exception {
		// TODO Auto-generated method stub
		return proveedorRepository.findAll();
	}

	@Override
	public Optional<Proveedor> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return proveedorRepository.findById(id);
	}

	@Override
	public Proveedor save(Proveedor entity) throws Exception {
		// TODO Auto-generated method stub
		return proveedorRepository.save(entity);
	}

	@Override
	public Proveedor update(Proveedor entity) throws Exception {
		// TODO Auto-generated method stub
		return proveedorRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		proveedorRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		proveedorRepository.deleteAll();
	}

}
