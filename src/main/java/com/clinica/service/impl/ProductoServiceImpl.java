package com.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.clinica.model.entity.Producto;
import com.clinica.model.repository.ProductoRepository;
import com.clinica.service.ProductoService;

public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	@Override
	public List<Producto> findAll() throws Exception {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public Optional<Producto> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return productoRepository.findById(id);
	}

	@Override
	public Producto save(Producto entity) throws Exception {
		// TODO Auto-generated method stub
		return productoRepository.save(entity);
	}

	@Override
	public Producto update(Producto entity) throws Exception {
		// TODO Auto-generated method stub
		return productoRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		productoRepository.deleteAll();
	}

}
