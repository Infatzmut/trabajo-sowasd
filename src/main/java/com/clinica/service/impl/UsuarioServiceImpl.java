package com.clinica.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.model.entity.Usuario;
import com.clinica.model.repository.UsuarioRepository;
import com.clinica.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findAll() throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Usuario> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}

	@Transactional
	@Override
	public Usuario save(Usuario entity) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.save(entity);
	}

	@Transactional
	@Override
	public Usuario update(Usuario entity) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		usuarioRepository.deleteAll();
	}

	@Transactional
	@Override
	public Optional<Usuario> findByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findByUsername(username);
	}

}
